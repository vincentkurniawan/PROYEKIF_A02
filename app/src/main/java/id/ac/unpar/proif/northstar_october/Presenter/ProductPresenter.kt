package id.ac.unpar.proif.northstar_october.Presenter

import id.ac.unpar.proif.northstar_october.Model.Code
import id.ac.unpar.proif.northstar_october.Model.Product
import id.ac.unpar.proif.northstar_october.View.IProducts
import java.util.*
import kotlin.collections.ArrayList

class ProductPresenter(private val ui: IProducts) {

    private var products: ArrayList<Product> = ArrayList()
    private var tempProducts: ArrayList<Product> = ArrayList()
    private var sortConditions = intArrayOf(Code.SORT_ASCENDING, Code.SORT_ASCENDING, Code.SORT_ASCENDING)

    fun loadProducts(newProduct: ArrayList<Product>) {
        products.addAll(newProduct)
        ui.loadProducts(products)
    }

    fun searchProducts(search: String) {
        val tempProduct = ArrayList<Product>()
        val size = products.size
        for (i in 0 until size) {
            if (products[i].name.lowercase().contains(search.lowercase())) {
                tempProduct.add(products[i])
            }
        }
        ui.loadProducts(tempProduct)
    }

    fun sortProducts (sortCode: Int) {
        when (sortCode) {
            Code.SORT_PRODUCTS_NAME -> {
                when (sortConditions[0]) {
                    Code.SORT_ASCENDING -> {
                        Collections.sort(products) { product, t1 -> t1.name.compareTo(product.name) }
                        sortConditions[0] = Code.SORT_DESCENDING
                    }
                    Code.SORT_DESCENDING -> {
                        Collections.sort(products) { product, t1 -> product.name.compareTo(t1.name) }
                        sortConditions[0] = Code.SORT_ASCENDING
                    }
                }
            }
            Code.SORT_PRODUCTS_CONDITION -> {
                when (sortConditions[1]) {
                    Code.SORT_ASCENDING -> {
                        Collections.sort(products) { product, t1 -> t1.condition.compareTo(product.condition) }
                        sortConditions[1] = Code.SORT_DESCENDING
                    }
                    Code.SORT_DESCENDING -> {
                        Collections.sort(products) { product, t1 -> product.condition.compareTo(t1.condition) }
                        sortConditions[1] = Code.SORT_ASCENDING
                    }
                }
            }
            Code.SORT_PRODUCTS_PRICE -> {
                when (sortConditions[2]) {
                    Code.SORT_ASCENDING -> {
                        Collections.sort(products) { product, t1 -> t1.price.compareTo(product.price) }
                        sortConditions[2] = Code.SORT_DESCENDING
                    }
                    Code.SORT_DESCENDING -> {
                        Collections.sort(products) { product, t1 -> product.price.compareTo(t1.price) }
                        sortConditions[2] = Code.SORT_ASCENDING
                    }
                }
            }
        }
        this.ui.loadProducts(products)
    }

    fun changeCategory(category: Int) {
        when (category) {
            Code.CATEGORY_DEFAULT -> ui.loadProducts(products)
            else -> {
                System.out.println(category)
                tempProducts = ArrayList()
                val productsSize = products.size
                for (i in 0 until productsSize) {
                    System.out.println(products[i].category)
                    if (products[i].category == category) {
                        tempProducts.add(products[i])
                    }
                }
                ui.loadProducts(tempProducts)
            }
        }
    }

    fun moveToDetails(product: Product) {
        ui.moveToDetails(product)
    }
}