package id.ac.unpar.proif.northstar_october.Presenter

import android.util.Log
import id.ac.unpar.proif.northstar_october.Model.Address
import id.ac.unpar.proif.northstar_october.View.IAddress

class AddressPresenter (private val ui: IAddress){
    private var addressList: ArrayList<Address> = ArrayList()

    fun addAddress (address: Address) {
        addressList.add(address)
        if (addressList.size == 1) {
            setFirstAddressDefault()
        }
        ui.loadAddress(addressList)
        ui.changeAddressOnPayment()
    }

    fun editAddress (addressAwal: Address, addressEdit: Address) {
        val idx = addressList.indexOf(addressAwal)
        Log.d ("IDX", "$idx")
        if (idx >= 0) {
            addressList[idx] = addressEdit
            if (addressAwal.getIsDefault()) {
                addressList[idx].makeDefault()
            }
        }
        ui.loadAddress(addressList)
        ui.changeAddressOnPayment()
    }

    fun removeAddress (address: Address) {

        val idx = addressList.indexOf(address)
        if (addressList[idx].getIsDefault()) {
            if (addressList.size > 1) {
                addressList[0].makeDefault()
            }
        }
        addressList.remove(address)
        ui.loadAddress(addressList)
        ui.changeAddressOnPayment()
    }

    fun makeDefaultAddress (address: Address) {
        // matikan seluruh isDefault address
        val len = addressList.size
        for (i in 0 until len) {
            addressList[i].removeDefault()
        }
        val idx = addressList.indexOf(address)
        addressList[idx].makeDefault()
        ui.loadAddress(addressList)
        ui.changeAddressOnPayment()
    }

    private fun setFirstAddressDefault () {
        val len = addressList.size
        if (len == 1) {
            addressList[0].makeDefault()
        }
    }

    fun getAddressListSize (): Int {
        return addressList.size
    }

    fun getDefaultAddress (): Address {
        val len = addressList.size
        for (i in 0 until len) {
            if (addressList[i].getIsDefault()) {
                return addressList[i]
            }
        }
        return Address ("", "", "")
    }
}