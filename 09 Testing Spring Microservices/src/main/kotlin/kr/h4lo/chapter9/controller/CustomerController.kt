package kr.h4lo.chapter9.controller

import kr.h4lo.chapter9.service.CustomerService
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

@RestController
class CustomerController(var customerService: CustomerService) {
    @RequestMapping(path = ["/customer/{id}"], method = [RequestMethod.GET])
    fun getCustomer(@PathVariable("id") id: Int) = customerService.getCustomer(id)

    @RequestMapping(path = ["/customers"], method = [RequestMethod.GET])
    fun getCustomers() = customerService.getAllCustomers()
}