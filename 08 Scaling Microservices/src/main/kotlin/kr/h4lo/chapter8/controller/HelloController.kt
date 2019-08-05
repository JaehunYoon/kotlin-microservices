package kr.h4lo.chapter8.controller

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController
import java.util.*
import java.util.concurrent.atomic.AtomicInteger

@RestController
class HelloController {
    private val id: String = UUID.randomUUID().toString()

    companion object {
        val total: AtomicInteger = AtomicInteger()
    }

    @RequestMapping(path = ["/hello"], method = [RequestMethod.GET])
    fun hello() = "Hello I'm $id and I have been called ${total.incrementAndGet()} time(s)"
}