package kr.h4lo.microservices.chapter4.controller

import kr.h4lo.microservices.chapter4.model.Customer
import kr.h4lo.microservices.chapter4.service.CustomerService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
class CustomerController {
    @Autowired
    private lateinit var customerService: CustomerService

    @RequestMapping(path = ["/customer/{id}"], method = [RequestMethod.GET])
    fun getCustomer(@PathVariable id: Int): ResponseEntity<Customer> {
        return ResponseEntity(Customer(id, "customer $id"), HttpStatus.OK)
    }

    @RequestMapping(path = ["/customers"])
    fun getCustomers(@RequestParam(required = false, defaultValue = "") nameFilter: String): List<Customer> {
        return customerService.searchCustomers(nameFilter)
    }
}