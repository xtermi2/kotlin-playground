package com.github.xtermi2.kotlin.playground

/**
 * @author Andreas Keefer
 */
fun main() {
    val bmw = Car("3", 180)
    bmw.printModel()

    val x3 = SUV("x3")
    x3.printModel()

    Child("Lisa")

    val car = DataClass("5", 210)
    car.printModel()
    println(car)
}

// open is necessary because by default all classes are final
// if using abstract, open is not necessary, because a final abstract class makes no sense
abstract class Vehicle(open val model: String) {

    open fun printModel() = println("model=$model")
    abstract fun calculatePrice(): Double

}

open class Car(model: String, open val powerKw: Int) : Vehicle(model) {
    // override is also open and you have to declare it final if you want it final
    final override fun printModel() = println("car model = $model with $powerKw kw")

    override fun calculatePrice() = 34000.99
}

class SUV(model: String) : Car(model, 250) {
    override fun calculatePrice() = 55000.95
}


open class Parent {
    val name: String

    constructor(name: String) {
        this.name = name
        println("parent constructor")
    }
}

class Child : Parent {

    // secondary constructor with super call
    constructor(name: String) : super(name) {
        println("child constructor")
    }
}

// data classes can't be open, but can extend other open or abstract classes
data class DataClass(override val model: String, override val powerKw: Int) : Car(model, powerKw)