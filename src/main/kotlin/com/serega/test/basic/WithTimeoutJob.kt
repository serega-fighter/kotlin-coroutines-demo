package com.serega.test.basic

import kotlinx.coroutines.*

fun main() = runBlocking {

    val job = launch(Dispatchers.Default) {
        var i = 0
        withTimeout(2000L) {
            repeat(1000) {
                i++;
                println("Iteration number $i")
                delay(500L)
            }
        }
    }

    job.join()
}