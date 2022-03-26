package id.ac.unpar.proif.northstar_october.View

import android.app.Activity
import android.app.AlertDialog
import android.content.DialogInterface
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.FragmentManager
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import id.ac.unpar.proif.northstar_october.Model.Address
import id.ac.unpar.proif.northstar_october.Model.Code
import id.ac.unpar.proif.northstar_october.Presenter.AddressPresenter
import id.ac.unpar.proif.northstar_october.R
import id.ac.unpar.proif.northstar_october.databinding.AddressItemBinding
import id.ac.unpar.proif.northstar_october.databinding.ProductPaymentItemBinding

class AddressAdapter (private val activity: Activity, private val presenter: AddressPresenter, private val fragmentManager: FragmentManager): BaseAdapter() {
    private var addressList: ArrayList<Address> = ArrayList()
    lateinit var binding: AddressItemBinding

    fun loadAddress (addressList: ArrayList<Address>) {
        this.addressList = addressList
        notifyDataSetChanged()
    }

    override fun getCount(): Int {
        return addressList.size
    }

    override fun getItem(i: Int): Address {
        return addressList[i]
    }

    override fun getItemId(i: Int): Long {
        return i.toLong()
    }

    override fun getView(i: Int, view: View?, viewGroup: ViewGroup?): View {
        var view: View? = view
        if (view == null) {
            binding = AddressItemBinding.inflate(activity.layoutInflater)
            view = binding.root
            view.setTag(binding)
        } else {
            binding = view.tag as AddressItemBinding
        }

        ViewHolder(getItem(i), binding)

        return view
    }

    inner class ViewHolder (private var currentAddress: Address, private var binding: AddressItemBinding): View.OnClickListener {
        init {
            binding.tvAddress.text = currentAddress.getAddress()
            binding.tvName.text = currentAddress.getName()
            binding.tvPhone.text = currentAddress.getPhoneNumber()

            var isFavoriteDrawable = when (currentAddress.getIsDefault()) {
                true -> Code.DRAWABLE_SOURCE_FAVORITE_ON
                false -> Code.DRAWABLE_SOURCE_FAVORITE_OFF
            }

            Glide.with(activity)
                .load(
                    activity.resources.getIdentifier(
                        isFavoriteDrawable,
                        "drawable",
                        activity.packageName
                    )
                )
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .into(binding.ivDefault)

            binding.ivDefault.setOnClickListener(this::onClick)
            binding.ivDelete.setOnClickListener(this::onClick)
            binding.ivEdit.setOnClickListener(this::onClick)

        }

        override fun onClick(view: View?) {
            when (view) {
                binding.ivDefault -> {
                    makeDefaultAddress()
                }
                binding.ivDelete -> {
                    deleteAddress()
                }
                binding.ivEdit -> {
                    editAddress()
                }
            }
        }

        private fun deleteAddress () {
            val builder = AlertDialog.Builder(activity)
            builder.setMessage(
                "Are you sure you want to delete?"
            )
                .setPositiveButton("Yes") { dialog, id ->
                    // DO SOMETHING
                    presenter.removeAddress(currentAddress)
                }
                .setNegativeButton("No") { dialog, id ->
                    dialog.dismiss()
                }
            builder.show()
        }

        private fun editAddress () {
            val builder = AlertDialog.Builder(activity)
            val inflater = activity.layoutInflater
            val view = inflater.inflate(R.layout.dialog_add_address, null)
            view.findViewById<TextView>(R.id.tv_add_address_title).text = "EDIT ADDRESS"
            builder.setView(view)
                .setPositiveButton("Save",
                    DialogInterface.OnClickListener { dialog, id ->
                        // add address
                        val address = view.findViewById<EditText>(R.id.et_address).text.toString()
                        val name = view.findViewById<EditText>(R.id.et_name).text.toString()
                        val phone = view.findViewById<EditText>(R.id.et_phone).text.toString()
                        when (checkAddress(address, name, phone)) {
                            true -> {
                                presenter.editAddress(currentAddress, Address(address, name, phone))
                            }
                            false -> {
                                invalidInputDialogCreateToast()
                            }
                        }
                    })
                .setNegativeButton("Cancel",
                    DialogInterface.OnClickListener { dialog, id ->
                        dialog.dismiss()
                    })
            builder.show()
        }

        private fun checkAddress (address: String, name: String, phone: String): Boolean {
            if (address != "" && name != "" && phone != "") {
                return true
            }
            return false
        }

        private fun makeDefaultAddress () {
            presenter.makeDefaultAddress(currentAddress)
        }

        private fun invalidInputDialogCreateToast() {
            val toast = Toast.makeText(activity, "Invalid input!", Toast.LENGTH_SHORT)
            toast.setGravity(Gravity.CENTER, 0, 0)
            toast.show()
        }
    }
}