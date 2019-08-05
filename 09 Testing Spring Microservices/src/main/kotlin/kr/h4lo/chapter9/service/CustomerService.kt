package kr.h4lo.chapter9.service

import kr.h4lo.chapter9.model.Customer

interface CustomerService {
    fun getCustomer(id: Int): Customer?
    fun getAllCustomers(): List<Customer>
}