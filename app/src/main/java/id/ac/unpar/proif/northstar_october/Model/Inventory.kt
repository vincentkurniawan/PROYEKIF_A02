package id.ac.unpar.proif.northstar_october.Model

class Inventory {
    var products:ArrayList<Product> = ArrayList()

    constructor() {
        products.add(Product("IPHONE 7", Code.CATEGORY_APPLE_PHONE, 200, Code.CONDITION_50, "Apple A10 Fusion (16 nm), 128 GB Storage 2 GB RAM, 12 MP f/1.8 28mm (wide), Battery Health 86%"))
        products.add(Product("IPHONE 8", Code.CATEGORY_APPLE_PHONE, 200, Code.CONDITION_50, "Apple A11 Bionic (10 nm), 256 GB Storage 2 GB RAM, 12 MP f/1.8 28mm (wide), Battery Health 90%"))
        products.add(Product("IPHONE X", Code.CATEGORY_APPLE_PHONE, 200, Code.CONDITION_50, "Apple A11 Bionic (10 nm), 64 GB Storage 3 GB RAM, 12 MP f/1.8 28mm (wide), Battery Health 94%"))
        products.add(Product("IPHONE XS", Code.CATEGORY_APPLE_PHONE, 200, Code.CONDITION_75, "Apple A12 Bionic (7 nm), 512GB Storage 4GB RAM, 12 MP f/1.8 28mm (wide), Battery Health 95"))
        products.add(Product("IPHONE XS MAX", Code.CATEGORY_APPLE_PHONE, 200, Code.CONDITION_75, "Apple A12 Bionic (7 nm), 128 GB Storage 4GB RAM, 12 MP f/1.8 28mm (wide), Battery Health 98%"))

        products.add(Product("IPHONE XR", Code.CATEGORY_APPLE_PHONE, 200, Code.CONDITION_90, "Apple A12 Bionic (7 nm), 64 GB Storage 3 GB RAM, 12 MP f/1.8 28mm (wide), Battery Health 95%"))
        products.add(Product("IPHONE 11", Code.CATEGORY_APPLE_PHONE, 200, Code.CONDITION_90, "Apple A13 Bionic (7 nm+), 128GB Storage 4GB RAM, 12 MP f/1.8 28mm (wide), Battery Health 93%"))
        products.add(Product("IPHONE 12", Code.CATEGORY_APPLE_PHONE, 200, Code.CONDITION_NEW, "Apple A14 Bionic (5 nm),  128GB Storage 4GB RAM, 12 MP f/1.8 28mm (wide),iOS 14.1 upgradable to iOS 15.4"))
        products.add(Product("IPHONE 12 PRO", Code.CATEGORY_APPLE_PHONE, 200, Code.CONDITION_NEW, "Apple A14 Bionic (5 nm),  128GB Storage 4GB RAM f/1.8 28mm (wide),iOS 14.1 upgradable to iOS 15.4"))
        products.add(Product("IPHONE 13", Code.CATEGORY_APPLE_PHONE, 200, Code.CONDITION_90, "Apple A15 Bionic (5 nm), 128GB Storage 4 GB RAM, 12 MP f/1.8 28mm (wide), iOS 15 upgradable to iOS 15.4"))

        products.add(Product("IPAD 6", Code.CATEGORY_APPLE_TABLET, 200, Code.CONDITION_50, "Apple A10 Fusion (16 nm), 32GB Storage 2GB RAM, 1.2 MP f/2.2 31mm (standard) Battery Health 90%"))
        products.add(Product("IPAD 7", Code.CATEGORY_APPLE_TABLET, 200, Code.CONDITION_75, "Apple A10 Fusion (16 nm), 32GB Storage 3GB RAM, 8 MP f/2.4 31mm (standard), Battery Health 92%"))
        products.add(Product("IPAD 8", Code.CATEGORY_APPLE_TABLET, 200, Code.CONDITION_75, "Apple A12 Bionic (7 nm), 128GB Storage 3GB RAM, 8 MP f/2.4 31mm (standard), Battery Health 98%"))
        products.add(Product("IPAD 9", Code.CATEGORY_APPLE_TABLET, 200, Code.CONDITION_NEW, "Apple A13 Bionic (7 nm+), 256GB Storage 3GB RAM, 8 MP f/2.4 31mm (standard), iPadOS 15 upgradable to iPadOS 15.4"))
        products.add(Product("IPAD MINI 6", Code.CATEGORY_APPLE_TABLET, 200, Code.CONDITION_NEW, "Apple A15 Bionic (5 nm), 256GB Storage 4GB RAM, 12 MP f/1.8 (wide) AF, iPadOS 15 upgradable to iPadOS 15.4"))

        products.add(Product("Huawei P50 PRO", Code.CATEGORY_ANDROID_PHONE, 200, Code.CONDITION_NEW, "Kirin 9000 (5 nm), 256GB Storage 8 RAM, 50 MP f/1.8 23mm (wide) AF, HarmonyOS 2.0 (China) EMUI 12 (Europe) no Google Play Services"))
        products.add(Product("IPHONE SE 2020", Code.CATEGORY_APPLE_TABLET, 200, Code.CONDITION_NEW, "Apple A13 Bionic (7 nm+), 256GB Storage 3GB RAM, 12 MP f/1.8 (wide, AF, iPadOS 15 upgradable to iPadOS 15.4"))
        products.add(Product("MI PAD 2", Code.CATEGORY_ANDROID_TABLET, 200, Code.CONDITION_50, "Intel Atom X5-Z8500, 64GB Storage 2GB RAM, 8 MP f/2.0, AF iPadOS 15, Android OS/ Optional Windows 10 (64 GB model) MIUI 7"))
        products.add(Product("MI PAD 4", Code.CATEGORY_APPLE_TABLET, 200, Code.CONDITION_75, "Qualcomm SDM660 Snapdragon 660 (14 nm), 64GB Storage 4GB RAM, 13 MP f/2.0, Android 8.1 (Oreo) MIUI 9"))
        products.add(Product("MI PAD 5", Code.CATEGORY_APPLE_TABLET, 200, Code.CONDITION_90, "Qualcomm Snapdragon 860 (7 nm), 256GB Storage 6GB RAM, 13 MP f/2.0, Android 11 MIUI 12.5"))

        products.add(Product("Redmi Note 10", Code.CATEGORY_ANDROID_PHONE, 200, Code.CONDITION_NEW, "Qualcomm SDM678 Snapdragon 678 (11 nm), 128GB Storage 6GB RAM, 48 MP f/1.8 26mm (wide), Android 11 MIUI 12.5"))
        products.add(Product("Poco F3 GT" , Code.CATEGORY_ANDROID_PHONE, 200, Code.CONDITION_NEW, "MediaTek MT6893 Dimensity 1200 5G (6 nm), 256GB Storage 8GB RAM, 64 MP f/1.7 26mm (wide), Android 11 upgradable to Android 12 MIUI 13 for POCO"))
        products.add(Product("Poco M3", Code.CATEGORY_ANDROID_PHONE, 200, Code.CONDITION_90, "Qualcomm SM6115 Snapdragon 662 (11 nm), 128GB Storage 6GB RAM, 48 MP f/1.8, (wide), Android 10, MIUI 12"))
        products.add(Product("Poco X3", Code.CATEGORY_ANDROID_PHONE, 200, Code.CONDITION_90, "Qualcomm SM7150-AC Snapdragon 732G (8 nm), 128GB Storage 8GB RAM, 64 MP f/1.9 (wide),Android 10, upgradable to Android 11 MIUI 12.5"))
        products.add(Product("Samsung Note 8", Code.CATEGORY_ANDROID_PHONE, 200, Code.CONDITION_75, "Exynos 8895 (10 nm), 256GB Storage 6GB RAM, 12 MP f/1.7 (wide), Android 7.1.1 (Nougat) upgradable to Android 9.0 (Pie)"))

        products.add(Product("Samsung S 10", Code.CATEGORY_ANDROID_PHONE, 200, Code.CONDITION_75, "Exynos 9820 (8 nm) , 612GB Storage 8GB RAM, 12 MP f/1.5-2.4 26mm (wide), Android 9.0 (Pie) upgradable to Android 12 One UI 4"))
        products.add(Product("Samsung S21", Code.CATEGORY_ANDROID_PHONE, 200, Code.CONDITION_NEW, "Exynos 2100 (5 nm), 256GB Storage 8GB RAM, 12 MP f/1.8 26mm (wide) 1/1.76 1.8µm Dual Pixel PDAF OIS,Android 11, One UI 3.1"))
        products.add(Product("Samsung S22", Code.CATEGORY_ANDROID_PHONE, 200, Code.CONDITION_NEW, "Qualcomm SM8450 Snapdragon 8 Gen 1 (4 nm), 256GB Storage 8GB RAM, 50 MP f/1.8 23mm (wide) 1/1.56 1.0µm Dual Pixel PDAF OIS, Android 12, One UI 4.1"))
        products.add(Product("Samsung Tab A7", Code.CATEGORY_ANDROID_TABLET, 200, Code.CONDITION_90, "Qualcomm SM6115 Snapdragon 662 (11 nm), 64GB Storage 3GB RAM, 8 MP AF, Android 10 upgradable to Android 11 One UI 3.1"))
        products.add(Product("Samsung Tab S7", Code.CATEGORY_ANDROID_TABLET, 200, Code.CONDITION_90, "Qualcomm SM8250 Snapdragon 865 5G+ (7 nm+), 512GB Storage 8GB RAM, 13 MP f/2.0 26mm (wide), Android 10, upgradable to Android 12, One UI 4"))

    }
}