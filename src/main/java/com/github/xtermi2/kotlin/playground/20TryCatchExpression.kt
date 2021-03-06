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

    // use is a try-with alternative in kotln. use is available on AutoCloseable or Closeable:
    {}.javaClass.getResourceAsStream("/testfile.txt")
            .use { it.reader().forEachLine { println(it) } }
}