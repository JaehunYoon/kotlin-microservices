package kr.h4lo.chapter5.service

import kr.h4lo.chapter5.model.Customer
import kr.h4lo.chapter5.repository.CustomerRepository
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono

@Service
class CustomerServiceImpl(var customerRepository: CustomerRepository): CustomerService {
    override fun getCustomer(id: Int) = customerRepository.findById(id)
    override fun createCustomer(customer: Mono<Customer>) = customerRepository.create(customer)
    override fun deleteCustomer(id: Int) = customerRepository.deleteById(id).map { it.deletedCount > 0 }
    override fun searchCustomers(nameFilter: String) = customerRepository.findCustomer(nameFilter)
}