package id.ac.unpar.proif.northstar_october.Presenter

import id.ac.unpar.proif.northstar_october.Model.Product
import id.ac.unpar.proif.northstar_october.Model.Box
import id.ac.unpar.proif.northstar_october.View.ICart

class CartPresenter (private val ui: ICart) {

    private var cart: ArrayList<Box> = ArrayList()

    fun loadCart (newCart: ArrayList<Box>) {
        cart.addAll(newCart)
        ui.loadCart(cart)
    }

    fun addProduct (product: Product) {
        val size = cart.size
        var check = false
        for (i in 0 until size) {
            if (cart[i].product == product) {
                cart[i].addQuantity(1)
                check = true
            }
        }
        when (check) {
            false -> cart.add(Box(product))
        }
        ui.loadCart(cart)
    }

    fun deleteProduct (box: Box) {
        cart.remove(box)
        ui.loadCart(cart)
    }

    fun changeQuantity (box: Box, value: Int) {
        val idx = cart.indexOf(box)
        cart[idx].makeQuantity(value)
        ui.loadCart(cart)
    }

    fun triggerSelected () {

    }
}