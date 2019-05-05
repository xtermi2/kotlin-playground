package com.github.xtermi2.kotlin.playground

/**
 * @author Andreas Keefer
 */
fun main() {
    lists()
    maps()
    sets()
    collectionUtils()
    sequences()
}

fun lists() {
    // immutable list
    val immutableLust = listOf("a", "b", "c", "d")
    println(immutableLust.javaClass)

    // mutable list
    val mutableList = mutableListOf(1, 2, 3)
    println(mutableList.javaClass)

    // get and set like arrays
    mutableList[1] = 22
    println(mutableList[1])

    // not null lists
    println(listOfNotNull("a", null, "c"))

    // added convenience functions in collections
    println(immutableLust.last())
    println(immutableLust.asReversed())
    println(immutableLust.getOrNull(5))
    println(immutableLust.getOrElse(5) { "e" })
    println(mutableList.max())
    println(immutableLust.zip(mutableList)) // creates Pairs
    println(immutableLust + mutableList)
    println(listOf("a", "b", "c", "x", "y", "z").union(immutableLust))
    println(listOf("a", "b", "c", "a").distinct())
}

fun maps() {
    println("########## MAPS ###########")

    val immutableMap = mapOf(
            1 to "One",
            2 to "Two",
            3 to "Three")
    println(immutableMap)
    for (entry in immutableMap) {
        println("key:${entry.key} value:${entry.value}")
    }

    // destructuring: extract object properties to variable
    for ((key, value) in immutableMap) {
        println("key:$key value:$value")
    }

    // destructuring in custom classes
    val (name, admin) = OrdinaryUser("Max")
    println("name:$name admin:$admin")

    // in data classes you get destructuring for free
    val (dataName, dataAdmin) = DataUser("Max")
    println("name:$dataName admin:$dataAdmin")
}

class OrdinaryUser(val name: String, var admin: Boolean = false) {
    //destructuring in custom classes require this implementation
    operator fun component1() = name

    operator fun component2() = admin
}


fun sets() {
    println("########## SETS ###########")

    // you get a linked hashSet
    val immutableSet = setOf("a", "b", "b")
    // add something to a set
    println(immutableSet.plus("c"))

    // drop the first 2 elements of the set
    println(immutableSet.plus("d").plus("e").drop(2))

    val mutableSet = mutableSetOf(1, 2, 3, 4, 5)
    // does not modify the original set
    mutableSet.plus(6)
    println(mutableSet)
}

fun collectionUtils() {
    println("########## collectionUtils ###########")

    val intSet = setOf(1, 2, 3, 4, 5)

    // odd ints
    println(intSet.filter { it % 2 != 0 })


    val users = mapOf(1 to DataUser("Max"),
            2 to DataUser("Alf", true),
            3 to DataUser("Mimi"))

    // non-Admins
    println(users.filterValues { !it.admin })

    println(intSet.map { it + it })
    println(intSet.flatMap { listOf(it, it) })
    // group by odd/even
    println(intSet.groupBy { it % 2 == 0 })
    // nope, not all ints are greater than 1
    println(intSet.all { it > 1 })
    // yes, there are some ints greater than 1
    println(intSet.any { it > 1 })
    println(intSet.count { it > 1 })

    println(users.values.sortedBy { it.name })
}

// sequences are the same as streams in java 8
// they should only be used for large data sets otherwise using collections directly is more efficient
fun sequences() {
    println("########## sequences ###########")

    val users = mapOf(1 to DataUser("Max"),
            2 to DataUser("Alf", true),
            3 to DataUser("Mimi"))

    println(users.asSequence()
            .filter { !it.value.admin }
            .map { it.value.name }
            .sorted()
            .toList())
}