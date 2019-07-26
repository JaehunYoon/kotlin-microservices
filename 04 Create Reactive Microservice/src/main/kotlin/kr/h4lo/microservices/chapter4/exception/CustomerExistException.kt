package kr.h4lo.microservices.chapter4.exception

import java.lang.Exception

class CustomerExistException(override val message: String): Exception(message)