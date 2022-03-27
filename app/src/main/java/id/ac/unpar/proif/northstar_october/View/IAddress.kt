package id.ac.unpar.proif.northstar_october.View

import id.ac.unpar.proif.northstar_october.Model.Address

interface IAddress {
    fun loadAddress (address: ArrayList<Address>)
    fun changeAddressOnPayment ()
}