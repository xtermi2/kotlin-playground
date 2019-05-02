package com.github.xtermi2.kotlin.playground

import java.math.BigDecimal

/**
 * @author Andreas Keefer
 */
fun main() {
    val status = 201

    // when expresion does not need breaks, like stitch cases in java,
    // but the possibility to jump to another case is not possible like in java without a break
    when (status) {
        // range
        in 200..299 -> println("status is 2xx")
        404 -> println(404)
        // multiple values
        401, 403 -> println("401 or 403")
        500 + 1 -> println("501")
        else -> println("some other status")
    }

    // when with smart casting
    val string = "String"
    val bigDecimal = BigDecimal.valueOf(12.5)
    val int = 5

    val something: Any = string

    val res = when (something) {
        is String -> println(something.toUpperCase())
        is BigDecimal -> println(something.divide(BigDecimal.TEN))
        is Int -> println("${something - 1}")
        else -> println("else/default block") // els block is not needed if a enum is in the when and all enum values are covered
    }
    println(res.javaClass)


    // when as shortcut for if
    when {
        status > int -> println("status > int")
        status < int -> println("status < int")
        else -> println("status = int")
    }
}