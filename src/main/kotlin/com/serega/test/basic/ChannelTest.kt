package com.serega.test.basic

import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.*
import kotlinx.coroutines.channels.ReceiveChannel

fun CoroutineScope.launchProcessor(id: Int, channel: ReceiveChannel<Int>) = launch {
    for (msg in channel) {
        println("Processor #$id received $msg")
    }
}

fun main() = runBlocking {

    val channel = Channel<Int>()

    launch {
        var x = 1 // start from 1
        while (isActive) {
            channel.send(x++) // produce next
            delay(10) // wait 0.1s
        }
    }

    repeat(5) { launchProcessor(it, channel) }

    println("Done!")
}