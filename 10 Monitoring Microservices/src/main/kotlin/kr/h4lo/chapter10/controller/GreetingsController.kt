package kr.h4lo.chapter10.controller

import kr.h4lo.chapter10.service.GreetingService
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

@RestController
class GreetingsController(var greetingService: GreetingService) {
    @RequestMapping(path = ["/hello"], method = [RequestMethod.GET])
    fun message() = greetingService.getGreeting()
}