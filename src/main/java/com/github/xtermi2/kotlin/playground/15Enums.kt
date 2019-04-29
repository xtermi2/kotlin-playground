package com.github.xtermi2.kotlin.playground

/**
 * @author Andreas Keefer
 */
fun main() {
    println(UserType.GUEST.hasRole("superuser"))
}

enum class UserType(val role: String) {
    ADMIN("superuser"),
    MASTER("master"),
    USER("ordinary user"),
    GUEST("read only"); // here you need a semicolon!!! if you have functions in enums

    fun hasRole(role: String) = this.role == role
}