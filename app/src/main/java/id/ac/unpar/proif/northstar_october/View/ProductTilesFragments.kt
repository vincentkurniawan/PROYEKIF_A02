package id.ac.unpar.proif.northstar_october.View

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import id.ac.unpar.proif.northstar_october.Model.Code
import id.ac.unpar.proif.northstar_october.Model.Inventory
import id.ac.unpar.proif.northstar_october.Model.Product
import id.ac.unpar.proif.northstar_october.Presenter.ProductPresenter
import id.ac.unpar.proif.northstar_october.R
import id.ac.unpar.proif.northstar_october.databinding.FragmentProductTilesBinding
import org.parceler.Parcels
import java.util.ArrayList

class ProductTilesFragments: Fragment(), IProducts, View.OnClickListener, AdapterView.OnItemSelectedListener {

    lateinit var inv: Inventory
    lateinit var binding: FragmentProductTilesBinding
    lateinit var presenter: ProductPresenter
    lateinit var adapter: ProductTilesAdapter
    private var availLoads = 0
    private var loadNumber = 0

    companion object {
        // singleton
        fun newInstance(inv: Inventory): ProductTilesFragments {
            val fragments = ProductTilesFragments()
            fragments.inv = inv
            return fragments
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // viewBinding
        binding = FragmentProductTilesBinding.inflate(inflater, container, false)

        // inisiasi
        presenter = ProductPresenter(this)
        adapter = ProductTilesAdapter(requireActivity(), presenter)

        // set adapter
        binding.lvProducts.adapter = adapter

        // filtering
        binding.etFilter.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {}
            override fun onTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {}
            override fun afterTextChanged(editable: Editable) {
                val search = binding.etFilter.text.toString()
                presenter.searchProducts(search)
            }
        })

        // spinner
        val ctSpinner = binding.categorySpinner
        val arr = arrayOf("ALL", "IPHONE", "IPAD", "ANDROID PHONE", "ANDROID TABLET")
        val adapter: ArrayAdapter<*> =
            ArrayAdapter<Any>(requireContext(), R.layout.category_spinner_item, arr)
        adapter.setDropDownViewResource(R.layout.category_spinner_item)
        ctSpinner.adapter = adapter
        ctSpinner.onItemSelectedListener = this

        // set onclick listener
        binding.ivList.setOnClickListener (this::onClick)
        binding.showMore.setOnClickListener (this::onClick)
        binding.ivCart.setOnClickListener(this::onClick)

        // load new products
        this.loadProducts()

        // set adapter
        binding.lvProducts.adapter = this.adapter
        return binding.root
    }

    private fun loadProducts() {
        val products = ArrayList<Product>()
        for (i in 0..4) {
            products.add(inv.products[i])
        }
        loadNumber = 5
        availLoads = inv.products.size - 5
        presenter.loadProducts(products)
    }

    private fun loadMoreProducts() {
        if (availLoads > 0) {
            val products = ArrayList<Product>()
            val max: Int
            max = if (availLoads < 5) {
                loadNumber + availLoads
            } else {
                loadNumber + 5
            }
            for (i in loadNumber until max) {
                println(i)
                products.add(inv.products[i])
            }
            presenter.loadProducts(products)
            loadNumber = max
            availLoads -= 5
        }
    }

    override fun loadProducts(products: ArrayList<Product>) {
        adapter.loadData(products)
    }

    override fun moveToDetails(product: Product) {
        val result = Bundle()
        result.putParcelable("products", Parcels.wrap(product))
        result.putInt("pageFrom", Code.PAGE_TILES_MODE)
        parentFragmentManager.setFragmentResult(Code.REQKEY_MOVE_TO_DETAILS, result)
        changePage(Code.PAGE_DETAILS_MODE)
    }

    override fun onClick(view: View) {
        // tombol ubah ke tiles mode
        when (view) {
            binding.ivList -> {
                changePage(Code.PAGE_LIST_MODE)
            }
            binding.showMore -> {
                loadMoreProducts()
            }
            binding.ivCart -> {
                changePage(Code.PAGE_CART)
                sentPageFromInformation()
            }
        }
    }

    private fun changePage(page: Int) {
        val result = Bundle()
        result.putInt("page", page)
        parentFragmentManager.setFragmentResult(Code.REQKEY_CHANGE_PAGE, result)
    }

    private fun sentPageFromInformation() {
        val result = Bundle()
        result.putInt("pageFrom", Code.PAGE_TILES_MODE)
        parentFragmentManager.setFragmentResult(Code.REQKEY_PAGE_FROM, result)
    }

    // Spinner selected-item
    override fun onItemSelected(adapterView: AdapterView<*>, view: View, i: Int, l: Long) {
        when (i) {
            0 -> presenter.changeCategory(Code.CATEGORY_DEFAULT)
            1 -> presenter.changeCategory(Code.CATEGORY_APPLE_PHONE)
            2 -> presenter.changeCategory(Code.CATEGORY_APPLE_TABLET)
            3 -> presenter.changeCategory(Code.CATEGORY_ANDROID_PHONE)
            4 -> presenter.changeCategory(Code.CATEGORY_ANDROID_TABLET)
        }
    }

    // Spinner nothing-selected-item
    override fun onNothingSelected(adapterView: AdapterView<*>) {}
}