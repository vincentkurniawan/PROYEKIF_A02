package id.ac.unpar.proif.northstar_october

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import id.ac.unpar.proif.northstar_october.Model.Code
import id.ac.unpar.proif.northstar_october.Model.Inventory
import id.ac.unpar.proif.northstar_october.View.ProductDetailsFragments
import id.ac.unpar.proif.northstar_october.View.ProductListFragments
import id.ac.unpar.proif.northstar_october.View.ProductTilesFragments
import id.ac.unpar.proif.northstar_october.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding
    lateinit var fm: FragmentManager
    lateinit var ft: FragmentTransaction
    lateinit var fragments: Array<Fragment>
    lateinit var productListFragments: ProductListFragments
    lateinit var productTilesFragments: ProductTilesFragments
    lateinit var productDetailsFragments: ProductDetailsFragments
    lateinit var inv: Inventory
    private var currentFragment = 0
    private var backPointer = intArrayOf(Code.PAGE_EXIT, Code.PAGE_LIST_MODE, Code.PAGE_LIST_MODE)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(this.binding.root)

        // Make new inventory
        this.inv = Inventory()

        // Fragment initiation
        this.fm = this.supportFragmentManager
        this.productListFragments = ProductListFragments.newInstance(this.inv)
        this.productTilesFragments = ProductTilesFragments.newInstance(this.inv)
        this.productDetailsFragments = ProductDetailsFragments.newInstance()
        fragments = arrayOf(this.productListFragments, this.productTilesFragments, this.productDetailsFragments)

        // Add product-list-fragment to fragment transaction
        val ft = this.fm.beginTransaction()
        ft.add(R.id.fragment_container, this.productListFragments).addToBackStack(null).commit()
        currentFragment = Code.PAGE_LIST_MODE

        // changePage listener
        this.supportFragmentManager.setFragmentResultListener(
            "CHANGE_PAGE", this
        ) { requestKey, result ->
            val page = result.getInt("page")
            changePage(page)
        }
    }

    private fun changePage (page: Int) {
        when (page) {
            Code.PAGE_EXIT -> {
                this.closeApplication()
            }
            else -> {
                ft = fm.beginTransaction()
                ft.hide(fragments[currentFragment])

                if (fragments[page].isAdded) {
                    ft.show(fragments[page])
                }
                else {
                    ft.add(R.id.fragment_container, fragments[page])
                }

                ft.commit()
                currentFragment = page
            }
        }
    }
    private fun closeApplication () {
        moveTaskToBack(true)
        finish()
    }

    override fun onBackPressed() {
        changePage(backPointer[currentFragment])
    }
}