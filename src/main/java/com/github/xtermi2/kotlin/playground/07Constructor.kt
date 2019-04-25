package com.github.xtermi2.kotlin.playground

/**
 * @author Andreas Keefer
 */
fun main() {
    println(User("foo").name)
    println(UserVerbose("verbose").name)
}

class User(val name: String) {

}

// same as User, but verbose
class UserVerbose(name: String) {

    val name: String

    init {
        this.name = name
    }

}