package com.example.springwebflux

import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse

@Component
class HelloHandler {

    fun sayHello(request: ServerRequest) =
            ServerResponse.ok()
                .bodyValue("Hello WebFlux")

}