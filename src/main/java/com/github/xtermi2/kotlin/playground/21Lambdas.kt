package com.github.xtermi2.kotlin.playground

/**
 * @author Andreas Keefer
 */
fun main() {
    // run can execute lambdas
    run { println("in lambda") }

    // lambdas with receiver objects
    println(countTo100())
    println(countTo100_apply())

    // labeling lambdas
    "Outer".apply outer@{
        "Inner".apply {
            println(toLowerCase())
            println(this@outer.toUpperCase())
        }
    }
}

// lambdas with receiver objects
fun countTo100() =
        with(StringBuilder()) {
            for (i in 1..99) {
                // in the lambda passed in the with block we can use the first parameter without writing the variable name
                append(i) // shortcut for this.append(i)
                append(", ")
            }
            append(100)
            toString()
        }

// lambdas with receiver objects
fun countTo100_apply() =
        StringBuilder().apply {
            for (i in 1..99) {
                // in the lambda passed in the with block we can use the first parameter without writing the variable name
                append(i) // shortcut for this.append(i)
                append(", ")
            }
            append(100)
        }.toString()