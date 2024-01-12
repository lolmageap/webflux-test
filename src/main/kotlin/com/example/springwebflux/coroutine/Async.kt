package com.example.springwebflux.coroutine

import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

fun sum(a: Int, b: Int) = a + b

fun main() = runBlocking<Unit> {

    val result = async {
        delay(100)
        sum(1, 3)
    }

    println("result1 : ${result.await()}")

    val result2 = async {
        delay(100)
        sum(2, 5)
    }

    println("result2 : ${result2.await()}")

}