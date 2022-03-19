package id.ac.unpar.proif.northstar_october.View

import id.ac.unpar.proif.northstar_october.Model.Product
import java.util.ArrayList

interface IProducts {
    fun loadProducts(products: ArrayList<Product>)
    fun moveToDetails(product: Product)
}