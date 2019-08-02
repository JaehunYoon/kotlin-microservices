package kr.h4lo.chapter7

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

@SpringBootApplication
class Chapter7Application

@RestController
class GreetingsController {
    @RequestMapping(path = ["/greetings"], method = [RequestMethod.GET])
    fun greetings() = "hello from a Docker"
}

fun main(args: Array<String>) {
    runApplication<Chapter7Application>(*args)
}
