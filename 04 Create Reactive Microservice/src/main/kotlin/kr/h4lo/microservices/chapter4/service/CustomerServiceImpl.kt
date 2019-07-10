package kr.h4lo.microservices.chapter4.service

import kr.h4lo.microservices.chapter4.model.Customer
import kr.h4lo.microservices.chapter4.model.Telephone
import org.springframework.stereotype.Component
import reactor.core.publisher.Mono
import reactor.core.publisher.toMono
import java.util.concurrent.ConcurrentHashMap

@Component
class CustomerServiceImpl: CustomerService {
    companion object {
        val initialCustomers = arrayOf(Customer(1, "Kotlin"),
                Customer(2, "Spring"),
                Customer(3, "Microservice", Telephone("+44", "7123456789")))
    }
    val customers = ConcurrentHashMap<Int, Customer>(initialCustomers.associateBy(Customer::id))

    override fun getCustomer(id: Int): Mono<Customer>? {
        return customers[id]?.toMono()
    }

    override fun searchCustomers(nameFilter: String): List<Customer> {
        return customers.filter {
            it.value.name.contains(nameFilter, true)
        }.map(Map.Entry<Int, Customer>::value).toList()
    }
}