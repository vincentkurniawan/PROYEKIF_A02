package id.ac.unpar.proif.northstar_october.Model

import android.os.Parcelable
import android.util.Log
import java.lang.StringBuilder
import kotlinx.parcelize.Parcelize
import kotlin.math.floor
import kotlin.math.log

@Parcelize
class Product() : Parcelable {
    private var name: String = ""
    private var category: Int = 0
    private var price: Int = 0
    private var condition: Int = 0
    private var description: String = ""
    private var photos: ArrayList<String> = ArrayList()

    constructor(name:String, category:Int, price:Int, condition:Int, description:String) : this() {
        this.name = name
        this.category = category
        this.price = price
        this.condition = condition
        this.description = description
        this.setPhoto(name)
    }

    companion object {
        const val CONDITION_DEFAULT = ""
        const val CONDITION_NEW = "NEW"
        const val CONDITION_90 = "95% CONDITION"
        const val CONDITION_75 = "75% CONDITION"
        const val CONDITION_50 = "50% CONDITION"

        const val CATEGORY_DEFAULT = ""
        const val CATEGORY_ANDROID_PHONE = "ANDROID PHONE"
        const val CATEGORY_ANDROID_TABLET = "ANDROID TABLET"
        const val CATEGORY_APPLE_PHONE = "APPLE PHONE"
        const val CATEGORY_APPLE_TABLET = "APPLE TABLET"

        const val PHOTO_SOURCE_PATH = "@drawable/"
    }

    fun getName(): String {
        return name
    }

    fun getDescription(): String {
        return description
    }

    fun getPhotos(): ArrayList<String> {
        return photos
    }

    fun getPrice(): Int {
        return price
    }

    fun getCategory(): Int {
        return category
    }

    fun getCondition(): Int {
        return condition
    }

    fun getFormattedCategory (): String {
        return when (this.category) {
            Code.CATEGORY_ANDROID_PHONE -> CATEGORY_ANDROID_PHONE
            Code.CATEGORY_ANDROID_TABLET -> CATEGORY_ANDROID_TABLET
            Code.CATEGORY_APPLE_PHONE -> CATEGORY_APPLE_PHONE
            Code.CATEGORY_APPLE_TABLET -> CATEGORY_APPLE_TABLET
            else -> CATEGORY_DEFAULT
        }
    }

    fun getFormattedCondition (): String {
        return when (this.condition) {
            Code.CONDITION_50 -> CONDITION_50
            Code.CONDITION_75 -> CONDITION_75
            Code.CONDITION_90 -> CONDITION_90
            Code.CONDITION_NEW -> CONDITION_NEW
            else -> CONDITION_DEFAULT
        }
    }

    fun getFormattedPrice (): String {
        return "$ $price"
    }


    private fun setPhoto (name: String) {
        var lowerCaseName = name.lowercase()
        lowerCaseName = lowerCaseName.replace("\\s".toRegex(), "")
        for (i in 1..3) {
            val pathBuilder = StringBuilder()
            pathBuilder.append(PHOTO_SOURCE_PATH)
            pathBuilder.append(lowerCaseName)
            pathBuilder.append("_$i")
            photos.add(pathBuilder.toString())
        }
    }
}