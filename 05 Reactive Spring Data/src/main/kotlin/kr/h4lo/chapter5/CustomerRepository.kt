package kr.h4lo.chapter5

import kr.h4lo.chapter5.model.Customer
import kr.h4lo.chapter5.model.Telephone
import org.springframework.data.mongodb.core.ReactiveMongoTemplate
import org.springframework.stereotype.Repository
import reactor.core.publisher.Mono
import reactor.core.publisher.toMono

@Repository
class CustomerRepository(private val template: ReactiveMongoTemplate) {
    companion object {
        val initialCustomers = listOf(Customer(1, "Kotlin"),
                Customer(2, "Spring"),
                Customer(3, "Microservice", Telephone("+44", "7123456789")))
    }

    fun initializeRepository() =
            initialCustomers.map(Customer::toMono).map(this::create).map(Mono<Customer>::subscribe)

    fun create(customer: Mono<Customer>) = template.save(customer)
}