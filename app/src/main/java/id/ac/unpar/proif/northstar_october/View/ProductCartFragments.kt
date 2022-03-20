package id.ac.unpar.proif.northstar_october.View

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import id.ac.unpar.proif.northstar_october.Model.Box
import id.ac.unpar.proif.northstar_october.Model.Code
import id.ac.unpar.proif.northstar_october.Model.Product
import id.ac.unpar.proif.northstar_october.Presenter.CartPresenter
import id.ac.unpar.proif.northstar_october.databinding.FragmentCartBinding
import org.parceler.Parcels

class ProductCartFragments: Fragment(), View.OnClickListener, ICart {

    private lateinit var binding: FragmentCartBinding
    private lateinit var presenter: CartPresenter
    private lateinit var adapter: ProductCartAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentCartBinding.inflate(inflater, container, false)

        presenter = CartPresenter(this)

        binding.home.setOnClickListener(this::onClick)
        return binding.root
    }

    override fun onClick(view: View?) {
        when (view) {
            binding.home -> {
                changePage(Code.PAGE_LIST_MODE)
            }
        }
    }

    override fun loadCart(cart: ArrayList<Box>) {
        adapter.loadData(cart)
    }

    private fun changePage (page: Int) {
        val result = Bundle()
        result.putInt("page", page)
        parentFragmentManager.setFragmentResult("CHANGE_PAGE", result)
    }

}