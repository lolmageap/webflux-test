package com.example.springwebflux.r2dbc

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono

@RestController("/foods")
class FoodController(
    private val foodRepository: FoodRepository,
) {

    @GetMapping("/{name}")
    fun getByName(@PathVariable name: String): Mono<Food> =
        foodRepository.findByName(name)

    @PostMapping
    fun create(@RequestBody map: Map<String, Any>): Mono<Food> =
        Food(
            name = map["name"].toString(),
            price = map["price"] as Int,
        ).let {
            foodRepository.save(it)
        }

}