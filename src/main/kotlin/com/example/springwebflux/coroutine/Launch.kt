package com.example.springwebflux.coroutine

import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

fun main() = runBlocking<Unit> {

    val job = launch {
        measureTimeMillis {
            delay(150)
        }.let {
            println("async task-1 $it ms")
        }
    }
    job.cancel()

    val job2 = launch(start = CoroutineStart.LAZY) {
        measureTimeMillis {
            delay(100)
        }.let {
            println("async task-2 $it ms")
        }
    }

    println("start-task-2")

    job2.start()
}