package com.github.xtermi2.kotlin.playground

/**
 * @author Andreas Keefer
 */
fun main() {
    val publicClass = PublicClass()
    publicClass.print()
    println(publicClass.foo)
    publicClass.setPrivate("changed private value")
    println(publicClass.getPrivate())

    val privateClass = PrivateClass()
    // private not visible from outside
    //privateClass.print()
    // protected is also not visible
    //privateClass.printProtected()

    InternalClass().print()
}


// default visibility is public for classes
class PublicClass {

    // default is public
    var foo: String = "bar"

    // private properties are not available via default getter/setter, because getters and setters have the same visibility like the property
    private var private: String = "I'm private"

    fun print() {
        println("I'm public")
    }

    // this is not a getter in kotlin way, more like a hack or antipattern
    fun getPrivate(): String {
        return private;
    }

    // this is not a setter in kotlin way, more like a hack or antipattern
    fun setPrivate(private: String) {
        this.private = private;
    }
}

// this is only visible in the same file. there is no equivalent in Java, because a non-inner/anonymous class can't be private
// private is compiled to package-private (Java)
private class PrivateClass {

    private fun print() {
        println("I'm public")
    }

    protected fun printProtected() {
        println("I'm public")
    }
}

// internal is only visible in the same module, but because internal is compiled to public, it's accessible from java also
// outside of a module
internal class InternalClass {
    internal fun print() {
        println("I'm public")
    }
}

// same as in Java
//protected class OhNo