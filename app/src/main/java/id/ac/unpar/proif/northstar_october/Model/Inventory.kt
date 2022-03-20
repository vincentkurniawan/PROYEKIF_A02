package id.ac.unpar.proif.northstar_october.Model

class Inventory {
    var products:ArrayList<Product> = ArrayList()

    constructor() {
        products.add(Product("IPHONE 7", Code.CATEGORY_APPLE_PHONE, 200, Code.CONDITION_50, "Apple A10 Fusion (16 nm), 128 GB Storage 2 GB RAM, 12 MP, f/1.8, 28mm (wide), Battery Health 86%",arrayListOf<String>("@drawable/iphone7_1","@drawable/iphone7_2","@drawable/iphone7_3")))
        products.add(Product("IPHONE 8", Code.CATEGORY_APPLE_PHONE, 200, Code.CONDITION_50, "Apple A11 Bionic (10 nm), 256 GB Storage 2 GB RAM, 12 MP, f/1.8, 28mm (wide), Battery Health 90%",arrayListOf<String>("@drawable/iphone8_1","@drawable/iphone8_2","@drawable/iphone8_3")))
        products.add(Product("IPHONE X", Code.CATEGORY_APPLE_PHONE, 200, Code.CONDITION_50, "Apple A11 Bionic (10 nm), 64 GB Storage 3 GB RAM, 12 MP, f/1.8, 28mm (wide), Battery Health 94%",arrayListOf<String>("@drawable/iphone10_1","@drawable/iphone10_2","@drawable/iphone10_3")))
        products.add(Product("IPHONE XS", Code.CATEGORY_APPLE_PHONE, 200, Code.CONDITION_75, "Apple A12 Bionic (7 nm), 512GB Storage 4GB RAM, 12 MP, f/1.8, 28mm (wide), Battery Health 95",arrayListOf<String>("@drawable/iphone10s_1","@drawable/iphone10s_2","@drawable/iphone10s_3")))
        products.add(Product("IPHONE XS MAX", Code.CATEGORY_APPLE_PHONE, 200, Code.CONDITION_75, "Apple A12 Bionic (7 nm), 128 GB Storage 4GB RAM, 12 MP, f/1.8, 28mm (wide), Battery Health 98%",arrayListOf<String>("@drawable/iphone10smax_1","@drawable/iphone10smax_2","@drawable/iphone10smax_3")))


        products.add(Product("IPHONE XR", Code.CATEGORY_APPLE_PHONE, 200, Code.CONDITION_90, "Apple A12 Bionic (7 nm), 64 GB Storage 3 GB RAM, 12 MP, f/1.8, 28mm (wide), Battery Health 95%",arrayListOf<String>("@drawable/iphone10r_1","@drawable/iphone10r_2","@drawable/iphone10r_3")))
        products.add(Product("IPHONE 11", Code.CATEGORY_APPLE_PHONE, 200, Code.CONDITION_90, "Apple A13 Bionic (7 nm+), 128GB Storage 4GB RAM, 12 MP, f/1.8, 28mm (wide), Battery Health 93%",arrayListOf<String>("@drawable/iphone11_1","@drawable/iphone11r_2","@drawable/iphone11_3")))
        products.add(Product("IPHONE 12", Code.CATEGORY_APPLE_PHONE, 200, Code.CONDITION_NEW, "Apple A14 Bionic (5 nm),  128GB Storage 4GB RAM, f/1.8, 28mm (wide),iOS 14.1, upgradable to iOS 15.4",arrayListOf<String>("@drawable/iphone12_1","@drawable/iphone12r_2","@drawable/iphone12_3")))
        products.add(Product("IPHONE 12 PRO", Code.CATEGORY_APPLE_PHONE, 200, Code.CONDITION_NEW, "Apple A14 Bionic (5 nm),  128GB Storage 4GB RAM, f/1.8, 28mm (wide),iOS 14.1, upgradable to iOS 15.4",arrayListOf<String>("@drawable/iphone12pro_1","@drawable/iphone12pro_2","@drawable/iphone12pro_3")))
        products.add(Product("IPHONE 13", Code.CATEGORY_APPLE_PHONE, 200, Code.CONDITION_90, "Apple A15 Bionic (5 nm), 128GB Storage 4 GB RAM, 12 MP, f/1.8, 28mm (wide), iOS 15, upgradable to iOS 15.4",arrayListOf<String>("@drawable/iphone13_1","@drawable/iphone13_2","@drawable/iphone13_3")))


        products.add(Product("IPAD 6", Code.CATEGORY_APPLE_TABLET, 200, Code.CONDITION_50, "Apple A10 Fusion (16 nm), 32GB Storage 2GB RAM, 1.2 MP, f/2.2, 31mm (standard) Battery Health 90%",arrayListOf<String>("@drawable/ipad6_1","@drawable/ipad6_2","@drawable/ipad6_3")))
        products.add(Product("IPAD 7", Code.CATEGORY_APPLE_TABLET, 200, Code.CONDITION_75, "Apple A10 Fusion (16 nm), 32GB Storage 3GB RAM, 8 MP, f/2.4, 31mm (standard), Battery Health 92%",arrayListOf<String>("@drawable/ipad7_1","@drawable/ipad7_2","@drawable/ipad7_3")))
        products.add(Product("IPAD 8", Code.CATEGORY_APPLE_TABLET, 200, Code.CONDITION_75, "Apple A12 Bionic (7 nm), 128GB Storage 3GB RAM, 8 MP, f/2.4, 31mm (standard), Battery Health 98%",arrayListOf<String>("@drawable/ipad8_1","@drawable/ipad8_2","@drawable/ipad8_3")))
        products.add(Product("IPAD 9", Code.CATEGORY_APPLE_TABLET, 200, Code.CONDITION_NEW, "Apple A13 Bionic (7 nm+), 256GB Storage 3GB RAM, 8 MP, f/2.4, 31mm (standard), iPadOS 15, upgradable to iPadOS 15.4",arrayListOf<String>("@drawable/ipad9_1","@drawable/ipad9_2","@drawable/ipad9_3")))
        products.add(Product("IPAD MINI 6", Code.CATEGORY_APPLE_TABLET, 200, Code.CONDITION_NEW, "Apple A15 Bionic (5 nm), 256GB Storage 4GB RAM, 12 MP, f/1.8, (wide), AF, iPadOS 15, upgradable to iPadOS 15.4",arrayListOf<String>("@drawable/ipadmini6_1","@drawable/ipadmini6_2","@drawable/ipadmini6_3")))

    }
}