package com.github.xtermi2.kotlin.playground

/**
 * @author Andreas Keefer
 */
fun main() {
    val javaClass = MyJavaClass()

    // kotlin uses the @NotNull and @Nullable annotations to generate code which checks this at runtime
    javaClass.lastName = null
    javaClass.name = "Foo"
    javaClass.admin = null

    println(javaClass)

    var admin = javaClass.admin
    // by default java types are nullable
    admin = null
    var admin2: Boolean? = javaClass.admin
    //admin2 = null

    var nameIsNotNullable = javaClass.name
    // when annotated with @NotNull, you get a non-nullable variable
    //nameIsNotNullable = null

    // varargs
    javaClass.printVarargs("a", "b", "c")
    javaClass.printVarargs(*arrayOf("a", "b", "c"))

    // static fields/methods are handled like companion objects
    MyJavaClass.x = 123
    MyJavaClass.printX()

    // SAM - single abstract method (functional interfaces)
    // we can pass a lambda like in java
    javaClass.run({ println("I'm in a runable") })
}
