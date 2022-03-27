package id.ac.unpar.proif.northstar_october.Model

import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner
import java.util.ArrayList

@RunWith(MockitoJUnitRunner::class)
class InventoryTest{




    @Before
    fun setup(){
    }

    @Test
    fun inventoryTest(){
        var products:ArrayList<Product> = ArrayList()
        products.add(Product("IPHONE 7", Code.CATEGORY_APPLE_PHONE, 200, Code.CONDITION_50, "Apple A10 Fusion (16 nm), 128 GB Storage 2 GB RAM, 12 MP f/1.8 28mm (wide), Battery Health 86%"))
        val result = products.size == 1
        assertTrue(result)

    }


}