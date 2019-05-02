package com.github.xtermi2.kotlin.playground.otherpackage

import com.github.xtermi2.kotlin.playground.UserType.ADMIN
import com.github.xtermi2.kotlin.playground.DataUser as User
import com.github.xtermi2.kotlin.playground.myUpper as newUpper

/**
 * @author Andreas Keefer
 */
fun main() {
    println(ADMIN.hasRole("bla"))

    // imported DataUser as User (type aliases)
    println(User("Kim"))

    // import extension function myUpper as newUpper
    println("foo".newUpper())
}