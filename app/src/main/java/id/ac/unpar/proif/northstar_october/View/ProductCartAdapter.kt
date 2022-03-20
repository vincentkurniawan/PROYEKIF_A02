package id.ac.unpar.proif.northstar_october.View

import android.app.Activity
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import androidx.fragment.app.FragmentManager
import id.ac.unpar.proif.northstar_october.Model.Box
import id.ac.unpar.proif.northstar_october.Presenter.CartPresenter
import id.ac.unpar.proif.northstar_october.databinding.ProductCartItemBinding

class ProductCartAdapter(private val activity: Activity, private var presenter: CartPresenter) : BaseAdapter() {
    lateinit var binding: ProductCartItemBinding
    var boxes: ArrayList<Box> = ArrayList()

    fun loadData (boxes: ArrayList<Box>) {
        this.boxes = ArrayList()
        this.boxes.addAll(boxes)
        notifyDataSetChanged()
    }

    override fun getCount(): Int {
        return boxes.size
    }

    override fun getItem(i: Int): Any {
        return boxes[i]
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getView(i: Int, view: View?, viewGroup: ViewGroup?): View {
        binding = when(view) {
            null -> {
                ProductCartItemBinding.inflate(activity.layoutInflater)
            }
            else -> {
                view.tag as ProductCartItemBinding
            }
        }

        return binding.root
    }

    inner class ViewHolder (private var binding: ProductCartItemBinding, private var currentBox: Box, fragmentManager: FragmentManager): View.OnClickListener {

        override fun onClick(view: View?) {
            when (view) {
                binding.checkbox -> {
                    if (binding.checkbox.isChecked){
                        // request nambah total

                    }else{
                        // request kurangin total
                    }
                    currentBox.triggerSelected()
                }
            }
        }

        fun requestChangeTotal () {

        }

    }

}