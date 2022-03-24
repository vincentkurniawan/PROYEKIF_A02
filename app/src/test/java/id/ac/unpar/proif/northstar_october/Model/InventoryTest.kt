package id.ac.unpar.proif.northstar_october.Model

import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner
import java.util.ArrayList

@RunWith(MockitoJUnitRunner::class)
class InventoryTest{

    @Mock
    lateinit var inv: Inventory

    @Before
    fun setup(){
        this.inv = Inventory()
    }

    @Test
    fun inventoryTest(){

        assertTrue(true)

    }


}