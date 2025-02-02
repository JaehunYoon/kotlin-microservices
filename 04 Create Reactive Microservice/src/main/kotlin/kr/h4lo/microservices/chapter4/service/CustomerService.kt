package kr.h4lo.microservices.chapter4.service

import kr.h4lo.microservices.chapter4.model.Customer
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

interface CustomerService {
    fun getCustomer(id: Int): Mono<Customer>
    fun searchCustomers(nameFilter: String): Flux<Customer>
    fun createCustomer(customerMono: Mono<Customer>): Mono<Customer>
}