package com.github.xtermi2.kotlin.playground

/**
 * @author Andreas Keefer
 */
fun main() {
    val strList = listOf("a", "b", "c")
    strList.printCollection()

    val intList = listOf(1, 2, 3)
    intList.printCollection()
    intList.printAsInt()

    setOf(2.1, 3.2, 4.3).printAsInt()

    append(StringBuilder("1"), StringBuilder("2"))

    var anyList = listOf<Any>("a", "b", "c")
    //anyList = intList

    if (anyList is List<*>) {
        // generics are removed at compile time, so the JVM can't check generics, so in kotlin it's also not possible to check generic types
        println("anyList is of Any type :(")
        val strList = anyList as List<String>
        println(strList[0].toUpperCase())
    }

    // reified parameters
    val mixedTypes = listOf(1, 1.2, "3")
    println(getElementsOfType<Int>(mixedTypes))

    // covariance
    // because Garden is covariance we can pass here any subType of Vehicle2
    printVehiclesInGarage(Garage<Motorbike>())

    // contravariance
    val cleaner = object : VehicleCleaner<Vehicle2> {
        override fun clean(vehicle: Vehicle2) = println("cleaning vehicle ${vehicle.name}")
    }
    // the contravariance makes the compile more relaxed about more general types, so we can pass here aky super type of Motorbike
    val garage2 = Garage2<Motorbike>(listOf(Motorbike(), Motorbike()), cleaner)
    garage2.cleanVehicle(1)

    // use-site variance
    val input = mutableListOf(Motorbike(), Motorbike())
    val output = mutableListOf<Vehicle2>()
    copyVehicles<Vehicle2>(input, output)
    println(output)
}

// use-site variance
// this is like in java: input<? extends T> output<? super T>
fun <T> copyVehicles(input: MutableList<out T>, output: MutableList<in T>) {
    for (vehicle in input) {
        output.add(vehicle)
    }
}

fun <T> Iterable<T>.printCollection() {
    for (item in this) {
        println(item)
    }
}

// without :Any (upper bound) also null ellements are allowed. here only nun-null elements in the Iterable are allowed
fun <T : Any> printItterable(iterable: Iterable<T>) {
    for (item in iterable) {
        println(item)
    }
}

fun <T : Number> Iterable<T>.printAsInt() {
    for (item in this) {
        println("as Int: ${item.toInt()}")
    }
}

// define condition for T in a where condition
fun <T> append(item1: T, item2: T)
        where T : CharSequence, T : Appendable {
    println(item1.append(item2))
}

// if a function is inlined and the generic type is reified, then the generic type information will not be removed at compile time
// this is the only use case of reified: check type in a function
inline fun <reified T> getElementsOfType(list: List<Any>): List<T> {
    val wantedTypes = mutableListOf<T>()
    for (elements in list) {
        if (elements is T) {
            wantedTypes.add(elements)
        }
    }

    return wantedTypes
}

fun printVehiclesInGarage(garage: Garage<Vehicle2>) {
    println(garage)
}

open class Vehicle2(val name: String)

class Motorbike : Vehicle2("Bike")

// by default Garage is "invariance" and "out" makes it "covariance"
// you can just use it now in the out position, this means you can use T as return type, but not as a parameter in a function
// because generic types are not available at runtime, you could add any Vehicle2 without this restriction
class Garage<out T : Vehicle2>() {

    val vehicles = listOf<T>()

//    fun park(vehicle: T) {
//
//    }

    // with @UnsafeVariance you can say the compiler "I'm totally sure, that this parameter will not change the instance in any way"
    // but you can shoot in your knee if you do change the instance!!!
    fun contains(vehicle: @UnsafeVariance T): Boolean = vehicles.contains(vehicle)

    fun parkOut(i: Int): T = vehicles[i]
}

class Garage2<T : Vehicle2>(val vehicles: List<T>, val cleaner: VehicleCleaner<T>) {

    fun cleanVehicle(i: Int) = cleaner.clean(vehicles[i])
}

// this interface is contravariance. contravariance is the opposite of covariance:
// the generic type is only allowed as parameter, but not as return type because
interface VehicleCleaner<in T> {
    fun clean(vehicle: T)
}