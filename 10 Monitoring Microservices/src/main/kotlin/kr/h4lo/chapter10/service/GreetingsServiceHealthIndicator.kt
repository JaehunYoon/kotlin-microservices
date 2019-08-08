package kr.h4lo.chapter10.service

import org.springframework.boot.actuate.health.AbstractHealthIndicator
import org.springframework.boot.actuate.health.Health
import org.springframework.stereotype.Component

@Component
class GreetingsServiceHealthIndicator(var greetingsService: GreetingService): AbstractHealthIndicator() {
    override fun doHealthCheck(builder: Health.Builder) {
        val lastMessage = try {
            val message = greetingsService.getGreeting()
            builder.up()
            message
        } catch (exception: Exception) {
            builder.down()
            "ERROR:$exception"
        }
        builder.withDetail("lastMessage", lastMessage)
    }
}