@file:JvmName("ExtensionFunctions")
package com.github.xtermi2.kotlin.playground

/**
 * @author Andreas Keefer
 */
fun main() {
    // extension functions are a syntactical illusion

    // this is our "receiver object"
    val s = "lower"
    println(s.myUpper())

    // inline function
    Customer("Elise").doSomethingWithName { name -> println(name.myUpper()) }
}

// "receiver type" is String class
// in a extension function every public thing from the receiver type can be referenced
fun String.myUpper(): String = this.toUpperCase() // "this" can be removed


class Customer(val name: String) {
    // a inline function is not compiled as a function, it's body is directly placed at the caller
    // this is just a optimization and is often done by the JVM even if the inline keyword is not used
    // inline functions work best with lambda parameters
    inline fun doSomethingWithName(action: (String) -> Unit) {
        action(name)
    }
}
