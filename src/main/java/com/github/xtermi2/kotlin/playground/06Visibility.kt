package com.github.xtermi2.kotlin.playground

/**
 * @author Andreas Keefer
 */
fun main() {
    PublicClass()
    PrivateClass()
    InternalClass()
}


// default visibility is public for classes
class PublicClass

// this is only visible in the same file. there is no equivalent in Java, because a non-inner/anonymous class can't be private
// private is compiled to package-private (Java)
private class PrivateClass

// internal is only visible in the same module, but because internal is compiled to public, it's accessible from java also
// outside of a module
internal class InternalClass

// same as in Java
//protected class OhNo