package com.github.xtermi2.kotlin.playground

/**
 * @author Andreas Keefer
 */
fun main() {
    val user = User("foo")
    println("${user.name} is admin ${user.admin}")

    val userVerbose = UserVerbose("verbose")
    // we call the getter here, not the field, that's not possible in kotlin
    println("${userVerbose.name} is admin ${userVerbose.admin}")
}

// for all properties a default getter and setter is generated
// we can set defaults, that's also possible in all functions
class User(val name: String, val admin: Boolean = false)

// same as User, but verbose with primary constructor
class UserVerbose constructor(name: String, admin: Boolean) {

    val name: String
    val admin: Boolean

    // the init block is something like the constructor block in java
    init {
        this.name = name
        this.admin = admin
    }

    // a secondary constructor have to call the primary constructor
    constructor(name: String) : this(name, false)
}