package com.github.xtermi2.kotlin.playground

/**
 * @author Andreas Keefer
 */
fun main() {
    val someInt = 12
    val someByte: Byte = 12
    val someLong = 12L
    val someDouble = 12.1
    val someFloat = 12.1f

    // nullable variables
    val nullable: String? = null

    // null save operator
    println(nullable?.toUpperCase())

    // elvis operator
    val upperOrDefault = nullable?.toUpperCase() ?: "Some Default"
    println(upperOrDefault)
    try {
        // elvis operator can also throw exceptions
        nullable ?: throw NullPointerException("nullable is null")
    } catch (e: NullPointerException) {
        println("elvis operator can also throw exceptions")
    }

    // initialized array
    val intArray = arrayOf(1, 2, 3, 4, 5)
    // primitiveArray
    val primitiveArray = intArrayOf(1, 2, 3, 4, 5)
    // initialize array with lambda
    val oddArray = Array(5) { i -> i * 2 }
    oddArray.forEach { println(it) }
    // nullable array
    val nullableArray = arrayOfNulls<String>(3)
    nullableArray[1] = "one"
    nullableArray.forEach { println(it?.toUpperCase()) }
    // other nullable variant
    val nullableArray2 = Array<Byte?>(3) { i -> i.toByte() }

    // say the compiler, I'm sure, this is nut null even if it could
    val something: Int? = null
    something!!.toDouble() // -> KotlinNullPointerException
}