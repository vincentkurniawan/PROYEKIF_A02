package id.ac.unpar.proif.northstar_october.View

import android.app.Activity
import android.app.AlertDialog
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import androidx.fragment.app.FragmentManager
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import id.ac.unpar.proif.northstar_october.Model.Box
import id.ac.unpar.proif.northstar_october.Presenter.PaymentPresenter
import id.ac.unpar.proif.northstar_october.databinding.ProductPaymentItemBinding

class PaymentAdapter(private val activity: Activity, private val presenter: PaymentPresenter, fragmentManager: FragmentManager): BaseAdapter() {

    private var cart: ArrayList<Box> = ArrayList()
    private lateinit var binding: ProductPaymentItemBinding

    fun loadData (cart: ArrayList<Box>) {
        this.cart = cart
        notifyDataSetChanged()
    }

    override fun getCount(): Int {
        return cart.size
    }

    override fun getItem(i: Int): Box {
        return cart[i]
    }

    override fun getItemId(i: Int): Long {
        return i.toLong()
    }

    override fun getView(i: Int, view: View?, viewGroup: ViewGroup?): View {

        var view: View? = view
        if (view == null) {
            binding = ProductPaymentItemBinding.inflate(activity.layoutInflater)
            view = binding.root
            view.setTag(binding)
        } else {
            binding = view.tag as ProductPaymentItemBinding
        }

        ViewHolder(getItem(i), binding)

        return view
    }

    inner class ViewHolder (private var currentBox: Box, private var binding: ProductPaymentItemBinding): View.OnClickListener {
        init {
            binding.tvName.text = currentBox.getProduct().getName()
            binding.tvDescription.text = currentBox.getProduct().getDescription()
            binding.tvPrice.text = currentBox.getProduct().getFormattedPrice()
            Glide.with(activity)
                .load(
                    activity.resources.getIdentifier(
                        currentBox.getProduct().getPhotos()[0],
                        "drawable",
                        activity.packageName
                    )
                )
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .into(binding.ivProduct)
            binding.tvQuantity.text = currentBox.getQuantity().toString()

            binding.btnDecrease.setOnClickListener(this::onClick)
            binding.btnIncrease.setOnClickListener(this::onClick)
        }

        override fun onClick(view: View?) {
            when (view) {
                binding.btnIncrease -> {
                    presenter.addQuantity(currentBox, 1)
                }
                binding.btnDecrease -> {
                    if (currentBox.getQuantity() > 1) {
                        presenter.addQuantity(currentBox, -1)
                    }else{
                        showDeleteDialog()
                    }
                }
            }
            presenter.changeTotal()
        }

        private fun showDeleteDialog () {
            val builder = AlertDialog.Builder(activity)
            builder.setMessage(
                "Are you sure you want to delete?"
            )
                .setPositiveButton("Yes") { dialog, id ->
                    // DO SOMETHING
                    presenter.deleteBox(currentBox)
                    presenter.changeTotal()
                }
                .setNegativeButton("No") { dialog, id ->
                    dialog.dismiss()
                }
            builder.show()
        }
    }
}
