package com.example.springwebflux.coroutine

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

fun main() {

}

suspend fun doSomething() = coroutineScope {
    launch {
        delay(200)
        println("world!")
    }

    launch {
        println("hello")
    }
}