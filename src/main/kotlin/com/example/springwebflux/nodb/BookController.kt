package com.example.springwebflux.nodb

import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class BookController(
    private val bookService: BookService,
) {

    @GetMapping("/books")
    fun getAll() = bookService.getAll()

    @GetMapping("/books/{id}")
    fun get(@PathVariable id: Int) = bookService.get(id)

    @PostMapping("/books")
    fun add(@RequestBody request: Map<String, Any>) = bookService.add(request)

    @DeleteMapping("/books/{id}")
    fun delete(@PathVariable id: Int) = bookService.delete(id)

}