package id.ac.unpar.proif.northstar_october.Model

class Box {
    lateinit var product: Product
    var quantity = 0
    var selected = false

    constructor(product: Product) {
        this.product = product
    }

    fun makeQuantity (value: Int) {
        this.quantity = value
    }

    fun addQuantity (value: Int) {
        this.quantity += value
    }

    fun triggerSelected () {
        selected = when (selected) {
            false -> true
            true -> false
        }
    }
}