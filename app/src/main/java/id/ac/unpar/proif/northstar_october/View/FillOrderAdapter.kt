package id.ac.unpar.proif.northstar_october.View

import android.app.Activity
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import id.ac.unpar.proif.northstar_october.Model.Box
import id.ac.unpar.proif.northstar_october.Model.Product
import id.ac.unpar.proif.northstar_october.databinding.FillOrderItemBinding

class FillOrderAdapter(private val activity: Activity): BaseAdapter() {
    private lateinit var  selectedItems: ArrayList<Box>

    fun loadData (selectedItems: ArrayList<Box>) {
        this.selectedItems=selectedItems
        notifyDataSetChanged()
    }

    override fun getCount(): Int {
        return selectedItems.size
    }

    override fun getItem(p0: Int): Box {
        return selectedItems.get(p0)
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong();
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        var binding=FillOrderItemBinding.inflate(activity.layoutInflater)
        var oneBox= getItem(p0);
        var currentSelectedProduct = oneBox.product;

        binding.tvName.setText(currentSelectedProduct.name)
        binding.harga.setText(currentSelectedProduct.price.toString())
        binding.tvQuantity.setText(oneBox.quantity.toString())

        Glide.with(activity)
            .load(
                activity.resources.getIdentifier(
                    currentSelectedProduct.photos[0],
                    "drawable",
                    activity.packageName
                )
            )
            .diskCacheStrategy(DiskCacheStrategy.NONE)
            .into(binding.ivProduct)

        binding.btnIncrease.setOnClickListener ( object : View.OnClickListener{
            override fun onClick(clicked : View){
                oneBox.addQuantity(1)
            }
        })
        binding.btnDecrease.setOnClickListener ( object : View.OnClickListener{
            override fun onClick(clicked : View){
                oneBox.addQuantity(-1)
            }
        })

        return binding.root

    }
}
