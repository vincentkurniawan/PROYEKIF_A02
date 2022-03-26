package id.ac.unpar.proif.northstar_october.View

import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import id.ac.unpar.proif.northstar_october.Model.Address
import id.ac.unpar.proif.northstar_october.Model.Cart
import id.ac.unpar.proif.northstar_october.Model.Code
import id.ac.unpar.proif.northstar_october.Presenter.AddressPresenter
import id.ac.unpar.proif.northstar_october.Presenter.PaymentPresenter
import id.ac.unpar.proif.northstar_october.R
import id.ac.unpar.proif.northstar_october.databinding.FragmentManageAddressBinding
import org.parceler.Parcels

class AddressFragment: Fragment(), View.OnClickListener, IAddress {

    lateinit var binding: FragmentManageAddressBinding
    lateinit var presenter: AddressPresenter
    lateinit var adapter: AddressAdapter

    companion object {
        fun newInstance(): AddressFragment {
            return AddressFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        binding = FragmentManageAddressBinding.inflate(inflater, container, false)

        presenter = AddressPresenter(this)
        adapter = AddressAdapter(requireActivity(), presenter, parentFragmentManager)

        binding.lvAddress.adapter = adapter

        binding.ivBack.setOnClickListener(this::onClick)
        binding.btnAddAddress.setOnClickListener(this::onClick)

        return binding.root
    }

    override fun onClick(view: View?) {
        when (view) {
            binding.ivBack -> {
                changeAddressOnPayment()
                changePage(Code.PAGE_PAYMENT)
            }
            binding.btnAddAddress -> {
                createDialogAddAddress()
            }
        }
    }

    private fun changeAddressOnPayment () {
        if (presenter.getAddressListSize() > 0) {
            val address = presenter.getDefaultAddress()
            val result = Bundle()
            result.putParcelable("address", Parcels.wrap(address))
            parentFragmentManager.setFragmentResult(Code.REQKEY_CHANGE_ADDRESS_ON_PAYMENT, result)
        }
    }

    override fun loadAddress(address: ArrayList<Address>) {
        adapter.loadAddress(address)
    }

    private fun changePage (page: Int) {
        val result = Bundle()
        result.putInt("page", page)
        parentFragmentManager.setFragmentResult(Code.REQKEY_CHANGE_PAGE, result)
    }

    private fun createDialogAddAddress () {
        val builder = AlertDialog.Builder(activity)
        val inflater = requireActivity().layoutInflater
        val view = inflater.inflate(R.layout.dialog_add_address, null)
        builder.setView(view)
            .setPositiveButton("Add",
                DialogInterface.OnClickListener { dialog, id ->
                    // add address
                    val address = view.findViewById<EditText>(R.id.et_address).text.toString()
                    val name = view.findViewById<EditText>(R.id.et_name).text.toString()
                    val phone = view.findViewById<EditText>(R.id.et_phone).text.toString()
                    when (checkAddress(address, name, phone)) {
                        true -> {
                            addAddress(address, name, phone)
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

    private fun addAddress (address: String, name: String, phone: String) {
        presenter.addAddress(Address(address, name, phone))
    }

    private fun checkAddress (address: String, name: String, phone: String): Boolean {
        if (address != "" && name != "" && phone != "") {
            return true
        }
        return false
    }

    private fun invalidInputDialogCreateToast() {
        val toast = Toast.makeText(context, "Invalid input!", Toast.LENGTH_SHORT)
        toast.setGravity(Gravity.CENTER, 0, 0)
        toast.show()
    }
}