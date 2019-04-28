package com.github.xtermi2.kotlin.playground

/**
 * @author Andreas Keefer
 */
fun main() {
    val user2 = User2("andi", false)
    user2.admin = true
    println(user2.admin)
}

// to provide custom getter/setter just provide a ordinary parameter
class User2(val name: String, admin: Boolean = false) {

    // we need this to provide getters/setters
    var admin = admin
        // getters and setters must follow here, directly after the
        get() {
            println("custom get $field")
            // here you have access to the so called "backing field" using the field identifier
            return field
        }
        set(value) {
            println("custom set $value")
            field = value
        }

}