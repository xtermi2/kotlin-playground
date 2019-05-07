// you can rename the static class the kotlin compiler generates for all toplevel functions here
@file:JvmName("Functions")

package com.github.xtermi2.kotlin.playground

/**
 * @author Andreas Keefer
 */
fun main() {
    custom(1, 2)
    simpler(1, 2)
    // named arguments
    simpler(y = 2, x = 1)
    println(simpleString(1))

    myVararg("a", "b", "c", another = "d")

    val array = arrayOf("a", "b", "c")
    // spread operator is needed to extract the array elements and pass it as single arguments
    myVararg(*array, another = "d")

    val anotherArray = arrayOf("d", "e", "f")

    val combined = arrayOf(*array, *anotherArray, "g")

    myVararg(*combined, another = "h")
}

// Unit is the default return type and is equivalent to void
fun custom(x: Int, y: Int): Unit {
    println("x=$x; y= $y")
}

// when returning just one expression:
fun simpler(x: Int, y: Int) = println("x=$x; y= $y")

// with default and return one expression:
fun simpleString(x: Int, y: Int = 2) = "x=$x; y= $y"

// vararg can be in any position, but if not at the end, you have to use named arguments
fun myVararg(vararg strings: String, another: String) {
    strings.forEach { s -> println(s) }
    println("another=$another")
}
