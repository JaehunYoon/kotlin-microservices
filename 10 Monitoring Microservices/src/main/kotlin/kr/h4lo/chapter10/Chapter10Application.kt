package kr.h4lo.chapter10

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.RestController

@SpringBootApplication
class Chapter10Application
fun main(args: Array<String>) {
    runApplication<Chapter10Application>(*args)
}