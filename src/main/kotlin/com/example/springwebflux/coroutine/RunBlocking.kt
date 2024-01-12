package com.example.springwebflux.coroutine

import kotlinx.coroutines.runBlocking

// VM Option에 -Dkotlinx.coroutines.debug 추가
fun main() {

    runBlocking {
        println("Hello")
        println(Thread.currentThread().name)
    }

    println("World")
    println(Thread.currentThread().name)
}