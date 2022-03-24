package id.ac.unpar.proif.northstar_october.Model

import android.os.Bundle

object Code {
    const val PAGE_LIST_MODE = 0
    const val PAGE_TILES_MODE = 1
    const val PAGE_DETAILS_MODE = 2
    const val PAGE_CART = 3
    const val PAGE_EXIT = -100

    const val CONDITION_NEW = 100
    const val CONDITION_90 = 90
    const val CONDITION_75 = 70
    const val CONDITION_50 = 50

    const val CATEGORY_DEFAULT = 250
    const val CATEGORY_ANDROID_PHONE = 200
    const val CATEGORY_ANDROID_TABLET = 201
    const val CATEGORY_APPLE_PHONE = 300
    const val CATEGORY_APPLE_TABLET = 301

    const val SORT_PRODUCTS_NAME = 500
    const val SORT_PRODUCTS_CONDITION = 501
    const val SORT_PRODUCTS_PRICE = 502
    const val SORT_ASCENDING = 510
    const val SORT_DESCENDING = 511

    const val CATEGORY_FILTER_ON = 600
    const val CATEGORY_FILTER_OFF = 601

    // request key listener
    const val REQKEY_ADD_PRODUCT_TO_CART = "ADD_PRODUCT_TO_CART"
    const val REQKEY_CHANGE_PAGE = "CHANGE_PAGE"
    const val REQKEY_MOVE_TO_DETAILS = "MOVE_TO_DETAILS"
    const val REQKEY_MOVE_TO_PAYMENT = "MOVE_TO_PAYMENT"
    const val REQKEY_PAGE_FROM = "PAGE_FROM"
}