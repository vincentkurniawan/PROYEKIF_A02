package id.ac.unpar.proif.northstar_october.View

import android.app.Activity
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import id.ac.unpar.proif.northstar_october.Model.Product
import id.ac.unpar.proif.northstar_october.Presenter.ProductPresenter
import id.ac.unpar.proif.northstar_october.databinding.ProductTilesItemBinding
import java.util.ArrayList

class ProductTilesAdapter(private val activity: Activity, private var presenter: ProductPresenter) :
    BaseAdapter() {

    lateinit var binding: ProductTilesItemBinding
    var products: ArrayList<Product> = ArrayList()

    fun loadData(products: ArrayList<Product>) {
        this.products = products
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
            binding = ProductTilesItemBinding.inflate(
                activity.layoutInflater
            )
            view = binding.root
            view.setTag(binding)
        } else {
            binding = view.tag as ProductTilesItemBinding
        }

        // SET TEXT and PHOTO
        binding.name.text = currProduct.getName()
        binding.category.text = currProduct.getFormattedCategory()
        binding.condition.text = currProduct.getFormattedCondition()
        binding.price.text = currProduct.getFormattedPrice()

        //IMPLEMENTASI GLIDE LIBRARY
        Glide.with(activity)
            .load(
                activity.resources.getIdentifier(
                    currProduct.getPhotos()[0],
                    "drawable",
                    activity.packageName
                )
            )
            .diskCacheStrategy(DiskCacheStrategy.NONE)
            .into(binding.ivProducts)
        binding.root.setOnClickListener { presenter.moveToDetails(currProduct) }
        return binding.root
    }
}