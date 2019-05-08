package com.github.xtermi2.kotlin.playground

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * @author Andreas Keefer
 */
fun main() {
    runBlocking {
        launch {
            delay(1000L)
            println(" Coroutines")
        }
        print("Hello")
    }
}