package kr.h4lo.chapter9

import kr.h4lo.chapter9.service.CustomerService
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@SpringBootTest
class CustomerServiceTest {
    @Autowired
    lateinit var customerService: CustomerService

    @Test
    fun `we should get a customer with a valid id`() {
        val customer = customerService.getCustomer(1)
        Assert.assertNotNull(customer)
        Assert.assertEquals(customer?.name, "Kotlin")
    }

    @Test
    fun `we should get all customers`() {
        val customers = customerService.getAllCustomers()
        Assert.assertEquals(customers.size, 3)
    }
}