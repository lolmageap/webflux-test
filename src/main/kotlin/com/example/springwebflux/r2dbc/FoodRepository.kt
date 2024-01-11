package com.example.springwebflux.r2dbc

import org.springframework.data.repository.reactive.ReactiveCrudRepository
import reactor.core.publisher.Mono

interface FoodRepository: ReactiveCrudRepository<Food, Long> {

    fun findByName(name: String): Mono<Food>

}