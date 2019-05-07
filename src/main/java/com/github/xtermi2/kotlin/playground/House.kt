package com.github.xtermi2.kotlin.playground

import java.io.IOException

/**
 * @author Andreas Keefer
 */
fun topLevel() = println("topLevel")

class MyHouse(@JvmField var location: String) {
    companion object {

        // this annotation generates another static code for java
        @JvmStatic
        fun build() = println("build a house")
    }

    fun print(s: String) = println("non null print: $s")

    @Throws(IOException::class)
    fun throwCheckedException() {
        throw IOException("I'm a checked Exception")
    }

    @JvmOverloads
    fun defaultParams(s: String, b: Boolean = true) {
        println("s=$s; b=$b")
    }
}