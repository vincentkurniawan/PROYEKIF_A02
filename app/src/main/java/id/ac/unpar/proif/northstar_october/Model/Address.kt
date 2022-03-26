package id.ac.unpar.proif.northstar_october.Model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class Address (private var address: String, private var name: String, private var phoneNumber: String): Parcelable {
    private var isDefault: Boolean = false

    fun getAddress (): String {
        return address
    }

    fun getName (): String {
        return name
    }

    fun getPhoneNumber(): String {
        return phoneNumber
    }

    fun makeDefault () {
        isDefault = true
    }

    fun removeDefault () {
        isDefault = false
    }

    fun getIsDefault (): Boolean {
        return isDefault
    }
}