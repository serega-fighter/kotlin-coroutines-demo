package com.serega.test.basic

import kotlinx.coroutines.*

fun main() = runBlocking { // this: CoroutineScope
    launch { doWorld() }
    println("Hello")
}

suspend fun doWorld() = coroutineScope { // this: CoroutineScope
    launch {
        delay(2000L)
        println("World 2")
    }
    launch {
        delay(1000L)
        println("World 1")
    }
    println("Hello")
}