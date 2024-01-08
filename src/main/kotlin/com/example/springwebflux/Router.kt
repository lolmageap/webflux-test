package com.example.springwebflux

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.server.router

@Configuration
class Router(
    private val helloHandler: HelloHandler,
    private val userHandler: UserHandler,
) {

    @Bean
    fun helloRouter() =
        router {
            GET("/", helloHandler::sayHello)
        }

    @Bean
    fun userRouter() =
        router {
            "/users".nest {
                GET("/{id}", userHandler::getUser)
                GET(userHandler::getUsers)
            }
        }

}