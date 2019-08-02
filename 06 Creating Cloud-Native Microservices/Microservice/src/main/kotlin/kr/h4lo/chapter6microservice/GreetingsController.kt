package kr.h4lo.chapter6microservice

import org.springframework.beans.factory.annotation.Value
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

@RestController
class GreetingsController(@Value("\${microservice.example.greetings}")
                          private var greetings: String) {

    @RequestMapping(path = ["/greetings"], method = [RequestMethod.GET])
    fun greetings() = greetings
}