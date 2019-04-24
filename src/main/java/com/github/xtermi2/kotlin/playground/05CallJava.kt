package com.github.xtermi2.kotlin.playground

/**
 * @author Andreas Keefer
 */
fun main() {
    // no new required
    MyJavaClass().printInJava("Hello Java")

    // boxing to primitive type
    MyJavaClass().printInJava("true".toBoolean())

    // require primitive array to call this method
    MyJavaClass().printInJava(intArrayOf(1, 2, 3))


}