package com.github.xtermi2.kotlin.playground

/**
 * @author Andreas Keefer
 */

val MY_CONSTANT = "I'm a top level constant"

fun main() {
    println(MY_CONSTANT)

    val user1 = DataUser("Joe")
    println(user1)
    val user2 = DataUser("Joe")
    println(user1 == user2)

    // when copying, you can provide other values with labels/named parameters for some properties
    val user3 = user1.copy(admin = true)
    println(user3)
}

// main purpose is to store state
// we get toString, equals, hashCode and a copy function, but this can be overwritten
data class DataUser(val name: String, var admin: Boolean = false)