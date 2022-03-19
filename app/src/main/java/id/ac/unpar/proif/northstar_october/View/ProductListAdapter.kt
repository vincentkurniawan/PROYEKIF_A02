package id.ac.unpar.proif.northstar_october.View

import android.app.Activity
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import id.ac.unpar.proif.northstar_october.Model.Product
import id.ac.unpar.proif.northstar_october.Presenter.ProductPresenter
import id.ac.unpar.proif.northstar_october.databinding.ProductListItemBinding
import java.util.ArrayList

class ProductListAdapter(private val activity: Activity, private var presenter: ProductPresenter) : BaseAdapter() {

    lateinit var binding: ProductListItemBinding
    var products: ArrayList<Product> = ArrayList()

    fun loadData(products: ArrayList<Product>) {
        this.products = ArrayList()
        this.products.addAll(products)
        notifyDataSetChanged()
    }

    override fun getCount(): Int {
        return products.size
    }

    override fun getItem(i: Int): Product {
        return products[i]
    }

    override fun getItemId(i: Int): Long {
        return i.toLong()
    }

    override fun getView(i: Int, view: View?, viewGroup: ViewGroup): View {
        var view: View? = view
        val currProduct = getItem(i)
        if (view == null) {
            binding = ProductListItemBinding.inflate(activity.layoutInflater)
            view = binding.root
            view.setTag(binding)
        } else {
            binding = view.tag as ProductListItemBinding
        }

        // SET TEXT
        binding.productName.text = currProduct.name
        binding.category.text = currProduct.getCategory()
        binding.condition.text = currProduct.getCondition()
        binding.price.text = "$ " + currProduct.price
        binding.root.setOnClickListener { presenter.moveToDetails(currProduct) }
        return binding.root
    }
}