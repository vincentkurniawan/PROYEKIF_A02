package id.ac.unpar.proif.northstar_october.View

import android.os.Bundle
import android.view.Gravity
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import id.ac.unpar.proif.northstar_october.Model.Address
import id.ac.unpar.proif.northstar_october.Model.Box
import id.ac.unpar.proif.northstar_october.Model.Cart
import id.ac.unpar.proif.northstar_october.Model.Code
import id.ac.unpar.proif.northstar_october.Presenter.PaymentPresenter
import id.ac.unpar.proif.northstar_october.databinding.FragmentPaymentBinding
import org.parceler.Parcels


class PaymentFragment : Fragment(), View.OnClickListener, IPayment {
    lateinit var binding:FragmentPaymentBinding
    lateinit var presenter:PaymentPresenter
    lateinit var adapter: PaymentAdapter

    companion object {
        fun newInstance(): PaymentFragment {
            return PaymentFragment()
        }

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        binding = FragmentPaymentBinding.inflate(inflater, container, false)

        presenter = PaymentPresenter(this)
        adapter = PaymentAdapter(requireActivity(), presenter, parentFragmentManager)

        binding.lvCart.adapter = adapter

        // result listener
        parentFragmentManager.setFragmentResultListener(
            Code.REQKEY_MOVE_TO_PAYMENT, this
        ) { requestKey, result ->
            val cart = Parcels.unwrap<Any>(result.getParcelable("cart")) as Cart
            loadNewCart(cart.getCart())
            presenter.changeTotal()
        }
        parentFragmentManager.setFragmentResultListener(
            Code.REQKEY_CHANGE_ADDRESS_ON_PAYMENT, this
        ) { requestKey, result ->
            val address = Parcels.unwrap<Any>(result.getParcelable("address")) as Address
            presenter.setAddress(address)
        }

        binding.pay.setOnClickListener(this::onClick)
        binding.ivBack.setOnClickListener(this::onClick)
        binding.btnEditAddress.setOnClickListener(this::onClick)

        return binding.root
    }

    override fun onClick(view: View?) {
        when (view) {
            binding.ivBack -> {
                changePage(Code.PAGE_CART)
            }
            binding.btnEditAddress -> {
                changePage(Code.PAGE_ADDRESS)
            }
            binding.pay -> {
                if (presenter.getAddress().getAddress() != "") {
                    paymentSuccessfulCreateToast()
                }else{
                    paymentNotSuccessCreateToast()
                }
            }
        }
    }

    private fun changePage (page: Int) {
        val result = Bundle()
        result.putInt("page", page)
        parentFragmentManager.setFragmentResult(Code.REQKEY_CHANGE_PAGE, result)
    }

    override fun loadCart(cart: ArrayList<Box>) {
        adapter.loadData(cart)
    }

    override fun changeTotal(value: String) {
        binding.total.text = value
    }

    override fun removeBoxAtCart(box: Box) {
        val result = Bundle()
        result.putParcelable("box", Parcels.wrap(box))
        parentFragmentManager.setFragmentResult(Code.REQKEY_REMOVE_BOX_AT_CART, result)
    }

    override fun autoMovePageToCart() {
        changePage(Code.PAGE_CART)
    }

    override fun changeReceiverName(name: String) {
        binding.tvReceiverName.text = name
    }

    private fun loadNewCart (cart: ArrayList<Box>) {
        presenter.loadCart(cart)
    }

    private fun paymentSuccessfulCreateToast() {
        val address = presenter.getAddress()
        val toast = Toast.makeText(context, "Payment Successful!\nYour item will be delivered to ${address.getName()}\nAt ${address.getAddress()}\nWith phone number: ${address.getPhoneNumber()}", Toast.LENGTH_LONG)
        toast.setGravity(Gravity.CENTER, 0, 0)
        toast.show()
    }

    private fun paymentNotSuccessCreateToast() {
        val toast = Toast.makeText(context, "Please add receiver address information first!", Toast.LENGTH_LONG)
        toast.setGravity(Gravity.CENTER, 0, 0)
        toast.show()
    }

}