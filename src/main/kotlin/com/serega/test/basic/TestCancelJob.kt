package com.serega.test.basic

import kotlinx.coroutines.*

fun main() = runBlocking {
    val job = launch {
        repeat(1000) { i ->
            println("job: I'm sleeping $i ...")
            delay(500L)
        }
    }
    delay(1500L)
    job.cancel()
    job.join()
    println("main: Now I can quit.")
}