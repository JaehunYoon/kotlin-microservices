package kr.h4lo.microservices.chapter4.model

data class Customer (var id: Int = 0,
                     val name: String = "",
                     val telephone: Telephone? = null)