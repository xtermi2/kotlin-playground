package com.github.xtermi2.kotlin.playground

/**
 * @author Andreas Keefer
 */
fun main() {
    // with this line, the Singleton is creates (first usage)
    Logger.log("Hello World")

    // companion object as static accessor
    println(Something.accessPrivateVar())
    Something().changeprivateVar(5)
    println(Something.accessPrivateVar())

    // companion object as factory method
    println(FactoryMethod.justAssign("as is").name)
    println(FactoryMethod.upperOrLower("upper", true).name)

    var mutableCounter = 0

    // object keyword as anonymous object:
    FactoryMethod.justAssign("as is").print(object : Printable {
        override val uppercase: Boolean = true

        // anonymous object has access to non final variables from outside:
        override fun print() = println("anonymous print ... ${mutableCounter++}")
    })
    println(mutableCounter)
}

// object classes exist only once (Singleton)
// constructors are not allowed here
object Logger {
    fun log(msg: String) {
        println(msg)
    }
}

class Something {

    // inner companion object is like static in Java
    companion object {
        private var privateVar = 6

        fun accessPrivateVar() = "privateVar = $privateVar"
    }

    fun changeprivateVar(num: Int) {
        privateVar = num
    }
}

// constructor is private and you have to use one of the methods in the  companion object to construct a FactoryMethod class
class FactoryMethod private constructor(val name: String) {

    companion object {
        fun justAssign(name: String) = FactoryMethod(name)
        fun upperOrLower(name: String, upper: Boolean): FactoryMethod {
            if (upper) {
                return FactoryMethod(name.toUpperCase())
            } else {
                return FactoryMethod(name.toLowerCase())
            }
        }
    }

    fun print(printable: Printable) = printable.print()
}