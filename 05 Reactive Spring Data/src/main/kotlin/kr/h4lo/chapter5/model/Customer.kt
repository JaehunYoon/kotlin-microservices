package kr.h4lo.chapter5.model

import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "Customers")
data class Customer (var id: Int = 0,
                     var name: String = "",
                     var telephone: Telephone? = null)