package kr.h4lo.chapter10.service

import org.springframework.stereotype.Service
import java.util.*

@Service
class GreetingServiceImpl: GreetingService {
    companion object {
        private val greetingsMessages = arrayOf("Hello", "Olá", "Namaste", "Hola")
    }

    fun random(max: Int): Int = Random().nextInt(max) + 1

    override fun getGreeting(): String = greetingsMessages[random(4)]
}