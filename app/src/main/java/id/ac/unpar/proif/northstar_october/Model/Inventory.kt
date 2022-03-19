package id.ac.unpar.proif.northstar_october.Model

class Inventory {
    var products:ArrayList<Product> = ArrayList()

    constructor() {
        products.add(Product("IPHONE 7", Code.CATEGORY_APPLE_PHONE, 200, Code.CONDITION_90, "128 GB Storage, Battery Health 92%"))
        products.add(Product("IPHONE 8", Code.CATEGORY_APPLE_PHONE, 200, Code.CONDITION_90, "128 GB Storage, Battery Health 92%"))
        products.add(Product("IPHONE X", Code.CATEGORY_APPLE_PHONE, 200, Code.CONDITION_90, "128 GB Storage, Battery Health 92%"))
        products.add(Product("IPHONE XS", Code.CATEGORY_APPLE_PHONE, 200, Code.CONDITION_90, "128 GB Storage, Battery Health 92%"))
        products.add(Product("IPHONE XS MAX", Code.CATEGORY_APPLE_PHONE, 200, Code.CONDITION_90, "128 GB Storage, Battery Health 92%"))
        products.add(Product("IPHONE XR", Code.CATEGORY_APPLE_PHONE, 200, Code.CONDITION_90, "128 GB Storage, Battery Health 92%"))
        products.add(Product("IPAD MINI 6", Code.CATEGORY_APPLE_TABLET, 200, Code.CONDITION_90, "128 GB Storage, Battery Health 92%"))
    }
}