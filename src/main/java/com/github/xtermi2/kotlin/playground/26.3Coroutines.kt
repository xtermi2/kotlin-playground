package com.github.xtermi2.kotlin.playground

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * @author Andreas Keefer
 */
fun main() {
    runBlocking {
        launch { printDelayed(" Coroutines", 1000L) }
        print("Hello")
    }
}

suspend fun printDelayed(str: String, delayInMs: Long) {
    delay(delayInMs)
    println(str)
}