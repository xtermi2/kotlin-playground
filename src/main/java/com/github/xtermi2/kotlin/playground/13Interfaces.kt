package com.github.xtermi2.kotlin.playground

/**
 * @author Andreas Keefer
 */
fun main() {
    House().print()
    House().print()
}

// it's by default open, everything else would not make sense
interface Printable {

    // interfaces can have properties
    val uppercase: Boolean

    // property with default value
    val newline: Boolean
        get() = true

    fun print()
}

interface XMLPrintable : Printable {

    fun printXML()
}

class House : XMLPrintable {

    override val uppercase: Boolean = true

    override fun print() = printXML()

    override fun printXML() {
        var message = """<house></house>"""
        if (uppercase) {
            message = message.toUpperCase()
        }
        if (newline) {
            println(message)
        } else {
            print(message)
        }
    }

}