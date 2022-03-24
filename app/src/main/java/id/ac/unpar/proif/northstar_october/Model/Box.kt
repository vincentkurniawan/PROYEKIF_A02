package id.ac.unpar.proif.northstar_october.Model

class Box (private var product: Product)  {
    private var quantity = 1
    private var isChecked = false

    fun getProduct (): Product {
        return product
    }

    fun getQuantity (): Int {
        return quantity
    }

    fun addQuantity (value: Int) {
        quantity += value
    }

    fun getTotalPrice (): Int {
        return quantity * product.getPrice()
    }

    fun toogleChecked () {
        isChecked = when (isChecked) {
            true -> false
            false -> true
        }
    }

    fun getIsChecked (): Boolean {
        return isChecked
    }
}