package com.example.springwebflux.nodb

import org.springframework.stereotype.Service
import reactor.core.publisher.Mono
import reactor.kotlin.core.publisher.toFlux
import reactor.kotlin.core.publisher.toMono
import java.util.concurrent.atomic.AtomicInteger

@Service
class BookService {

    private final val nextId = AtomicInteger(0)

    val books = mutableListOf(
        Book(id = nextId.incrementAndGet(), name = "코틀린 인 액션", price = 30000),
        Book(id = nextId.incrementAndGet(), name = "HTTP 완벽 가이드", price = 40000),
        Book(id = nextId.incrementAndGet(), name = "이펙티브 자바", price = 35000),
    )

    fun getAll() = books.toFlux()

    fun get(id: Int) =
        books.find { it.id == id }
            .toMono()

    fun add(request: Map<String, Any>) =
        Mono.just(request)
            .map { map ->
                val book = Book(
                    id = nextId.incrementAndGet(),
                    name = map["name"].toString(),
                    price = map["price"] as Int,
                )

                books.add(book)
                book
            }

    fun delete(id: Int) =
        books.removeIf {
            it.id == id
        }
            .toMono()
            .then()

}

data class Book(
    val id: Int,
    val name: String,
    val price: Int,
)