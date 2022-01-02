package com.serega.test.basic

import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.*

fun main() = runBlocking {

    val channel = Channel<Int>()

    launch {
        for (x in 1..5) {
            channel.send(x * x)
            delay(1000)
        }
    }

    repeat(5) { println(channel.receive()) }
    println("Done!")
}