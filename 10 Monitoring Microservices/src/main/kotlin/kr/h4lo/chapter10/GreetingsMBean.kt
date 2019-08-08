package kr.h4lo.chapter10

import kr.h4lo.chapter10.service.GreetingService
import org.springframework.jmx.export.annotation.ManagedOperation
import org.springframework.jmx.export.annotation.ManagedOperationParameter
import org.springframework.jmx.export.annotation.ManagedOperationParameters
import org.springframework.jmx.export.annotation.ManagedResource
import org.springframework.stereotype.Component

@Component
@ManagedResource(objectName = "kr.h4lo:type=greetings, name=GetHello", description = "Get greetings")
class GreetingsMBean(var greetingsService: GreetingService) {
    @ManagedOperation(description = "Returns a greeting message")
    @ManagedOperationParameters(ManagedOperationParameter(description = "provide a name", name = "name"))
    fun hello(name: String) = try {
        greetingsService.getGreeting() + " $name!"
    } catch (exception: Exception) {
        "oh $name, we get an error: $exception"
    }
}