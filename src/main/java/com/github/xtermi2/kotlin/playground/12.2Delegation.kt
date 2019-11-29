package com.github.xtermi2.kotlin.playground

/**
 * @author Andreas Keefer
 */
fun main() {
    val engine = Engine(100)
    println(engine)

    val bike = MotorVehicle(engine)
    println(bike)

    println(bike.horsepower)
}

interface PowerSource {
    val horsepower: Int
}

data class Engine(override val horsepower: Int) : PowerSource

// This will automatically implement all the interface members of PowerSource in MotorVehicle
// by invoking the same member on engine.
// This only works for properties that are declared in the constructor.
data class MotorVehicle(val engine: Engine) : PowerSource by engine