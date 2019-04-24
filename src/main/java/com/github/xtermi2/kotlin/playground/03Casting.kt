package com.github.xtermi2.kotlin.playground

/**
 * @author Andreas Keefer
 */
fun main() {
    // Explicit Type, Any is the root of kotlin class hierarchy
    val any: Any = "some String"
    if (any is String) {
        // smart cast
        println(any.toUpperCase())
    }
}