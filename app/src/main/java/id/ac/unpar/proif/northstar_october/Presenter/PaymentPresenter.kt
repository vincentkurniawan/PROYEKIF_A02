package id.ac.unpar.proif.northstar_october.Presenter

import id.ac.unpar.proif.northstar_october.Model.Address
import id.ac.unpar.proif.northstar_october.Model.Box
import id.ac.unpar.proif.northstar_october.View.IPayment

class PaymentPresenter (private val ui: IPayment){

    private var cart: ArrayList<Box> = ArrayList()
    private var address: Address = Address("", "NOT SET YET", "")

    fun setAddress() {
        ui.changeReceiverName(this.address.getName())
    }

    fun setAddress (address: Address) {
        this.address = address
        ui.changeReceiverName(this.address.getName())
    }

    fun getAddress (): Address {
        return address
    }

    fun loadCart (cart: ArrayList<Box>) {
        this.cart = cart
        ui.loadCart(cart)
    }

    fun addQuantity (box: Box, value: Int) {
        val idx = cart.indexOf(box)
        cart[idx].addQuantity(value)
        ui.loadCart(cart)
    }

    fun changeTotal () {
        val len = cart.size
        var total = 0
        for (i in 0 until len) {
            if (cart[i].getIsChecked()) {
                total += cart[i].getTotalPrice()
            }
        }
        val formattedTotal = "$ $total"
        ui.changeTotal(formattedTotal)
    }

    fun deleteBox (box: Box) {
        cart.remove(box)
        ui.loadCart(cart)
        ui.removeBoxAtCart(box)

        if (cart.size <= 0) {
            ui.autoMovePageToCart()
        }
    }

    fun resetCart () {
        val len = cart.size
        for (i in 0 until len) {
            ui.removeBoxAtCart(cart[i])
        }
        cart.clear()
        ui.loadCart(cart)
        changeTotal()
    }
}