package com.github.xtermi2.kotlin.playground

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

/**
 * @author Andreas Keefer
 */
fun main() {
    GlobalScope.launch {
        delay(1000L)
        println(" Coroutines")
    }
    print("Hello")
    Thread.sleep(1500L)
}