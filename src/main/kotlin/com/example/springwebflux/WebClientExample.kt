package com.example.springwebflux

import org.slf4j.LoggerFactory
import org.springframework.core.ParameterizedTypeReference
import org.springframework.http.HttpMethod
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.client.RestTemplate
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.reactive.function.client.bodyToFlux
import reactor.core.publisher.Flux

@RestController
class WebClientExample {

    val url = "http://localhost:8080/books"

    val log = LoggerFactory.getLogger(javaClass)

    /**
     *  RestTemplate 은 코드가 순차적으로 실행된다.
     *  그렇다는건 RestTemplate 으로 호출한 값을 받을때까지 Thread 가 blocking 되어있다는 것
     *  Worst case : 여러개의 restTemplate 을 호출하고 결과를 결합해서 사용해야할 때
     */

    @GetMapping("books/block")
    fun getBooksBlockingWay(): List<Book> {
        log.info("Start RestTemplate")

        val restTemplate = RestTemplate()
        val response = restTemplate.exchange(url, HttpMethod.GET, null,
            object : ParameterizedTypeReference<List<Book>>() {}
        )

        val result = response.body!!

        log.info("result = $result")
        log.info("Finish RestTemplate")
        return result
    }

    @GetMapping("books/nonblock")
    fun getBooksNonBlockingWay(): Flux<Book> {
        log.info("Start WebClient")

        val retrieve = WebClient.create()
            .get()
            .uri(url)
            .retrieve()
            .bodyToFlux(Book::class.java)
            .map {
                log.info("result : {}", it)
                it
            }

        log.info("Finish WebClient")
        return retrieve
    }

}