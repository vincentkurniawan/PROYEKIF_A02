package id.ac.unpar.proif.northstar_october.View

import id.ac.unpar.proif.northstar_october.Model.Box

interface IPayment {
    fun loadCart (cart: ArrayList<Box>)
    fun changeTotal (value: String)
    fun removeBoxAtCart (box: Box)
    fun autoMovePageToCart ()
    fun changeReceiverName (name: String)
}