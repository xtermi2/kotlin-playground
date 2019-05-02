package com.github.xtermi2.kotlin.playground

/**
 * @author Andreas Keefer
 */
fun main() {
    println(parseStr("312"))
    println(parseStr("12.1"))
}

fun parseStr(str: String): Int {
    return try {
        str.toInt()
    } catch (e: NumberFormatException) {
        -1
    } finally {
        println("finally")
    }
}