package id.ac.unpar.proif.northstar_october.Model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
class Cart: Parcelable {

    private var cart: ArrayList<Box> = ArrayList()

    fun getCart (): ArrayList<Box> {
        return cart
    }

    fun addBoxToCart (box: Box) {
        cart.add(box)
    }
}