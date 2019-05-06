package com.github.xtermi2.kotlin.playground

import java.io.File

/**
 * @author Andreas Keefer
 */
fun main() {
    // use is like try-with in java

    {}.javaClass.getResourceAsStream("/testfile.txt").use { it.reader().forEachLine { println(it) } }

    println("----------------")

    // read from classpath
    val resource = {}.javaClass.getResource("/testfile.txt")
    println(resource)
    val testfile = resource.readText()
    println(testfile)

    println("----------------")

    // walking the file tree
    File(".").walkTopDown()
            .onEnter { println("enter $it"); true }
            .filter { it.name.endsWith(".kt") }
            .forEach { println(it) }
}