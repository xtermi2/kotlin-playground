package com.github.xtermi2.kotlin.playground

/**
 * this is a top level function, outside of a class
 */
fun main() {
    // val is like final (only assignable once / immutable variable)
    val language = "Kotlin"
    // var is mutable
    var hello = "H"
    hello = hello + "ello"
    // String templates
    println("$hello $language")

    // triple quoted string
    val json = """{
  "name" : "value",
  "price" : 12$,
  "language" : "$$language"
}"""
    println(json)

    val language2 = "Kotlin"

    // structural equals (=language.equals(language2))
    println(language == language2)
    // referential equals (same instance) ...
    println(language === language2) // is true because of a JVM optimization
}