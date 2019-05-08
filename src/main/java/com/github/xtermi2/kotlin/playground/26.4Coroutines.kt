package com.github.xtermi2.kotlin.playground

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.system.measureNanoTime

/**
 * @author Andreas Keefer
 */
fun main() {
    val nanos = measureNanoTime {
        runBlocking {
            repeat(100_000) {
                launch {
                    delay(1000L)
                    println(it)
                }
            }
        }
    }
    println("took $nanos ns")
    println("took ${nanos / 1000000} ms")
}

fun main1() {
    val nanos = measureNanoTime {
        repeat(100_000) {
            Thread({
                Thread.sleep(1000L)
                println(it)
            }).start()
        }
        Thread.sleep(60000L)
    }
    println("took $nanos ns")
    println("took ${nanos / 1000000} ms")
}

fun main2() {
    val nanos = measureNanoTime {
        repeat(100_000) {
            println(it)
        }
    }

}
