package com.example.springwebflux.nodb

import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse

@Component
class UserHandler {

    val users = listOf(
        User(1, "abcd@naver.com"),
        User(2, "abcd@gmail.com"),
    )

    fun getUser(request: ServerRequest) =
        users.find { it.id == request.pathVariable("id").toLong() }
            ?.let {
                ServerResponse.ok()
                    .bodyValue(it)
            }
            ?: ServerResponse.notFound().build()

    fun getUsers(request: ServerRequest) =
        ServerResponse.ok().bodyValue(users)

}

data class User(
    val id: Long,
    val email: String,
)