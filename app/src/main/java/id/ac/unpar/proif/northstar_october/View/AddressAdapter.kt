package id.ac.unpar.proif.northstar_october.View

import android.app.Activity
import android.app.AlertDialog
import android.content.DialogInterface
import android.util.Log
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.*
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

            toogleDefault()

            binding.ivDelete.setOnClickListener(this::onClick)
            binding.ivEdit.setOnClickListener(this::onClick)

        }

        private fun toogleDefault () {
            when (currentAddress.getIsDefault()) {
                true -> {
                    Log.d("VISIBLE","ON")
                    binding.btnDefault.visibility = View.VISIBLE
                }
                false -> {
                    Log.d("VISIBLE","GONE")
                    binding.btnDefault.visibility = View.GONE
                }
            }
        }

        override fun onClick(view: View?) {
            when (view) {
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
            view.findViewById<EditText>(R.id.et_address).setText(currentAddress.getAddress())
            view.findViewById<EditText>(R.id.et_name).setText(currentAddress.getName())
            view.findViewById<EditText>(R.id.et_phone).setText(currentAddress.getPhoneNumber())
            view.findViewById<Switch>(R.id.switch_default).isChecked = currentAddress.getIsDefault()
            builder.setView(view)
                .setPositiveButton("Save",
                    DialogInterface.OnClickListener { dialog, id ->
                        // add address
                        val address = view.findViewById<EditText>(R.id.et_address).text.toString()
                        val name = view.findViewById<EditText>(R.id.et_name).text.toString()
                        val phone = view.findViewById<EditText>(R.id.et_phone).text.toString()
                        val res = Address(address, name, phone)
                        when (checkAddress(address, name, phone)) {
                            true -> {
                                presenter.editAddress(currentAddress, res)
                            }
                            false -> {
                                invalidInputDialogCreateToast()
                            }
                        }
                        if (view.findViewById<Switch>(R.id.switch_default).isChecked) {
                            presenter.makeDefaultAddress(res)
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

        private fun invalidInputDialogCreateToast() {
            val toast = Toast.makeText(activity, "Invalid input!", Toast.LENGTH_SHORT)
            toast.setGravity(Gravity.CENTER, 0, 0)
            toast.show()
        }
    }
}