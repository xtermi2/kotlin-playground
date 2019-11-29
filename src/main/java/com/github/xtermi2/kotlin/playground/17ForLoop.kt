package com.github.xtermi2.kotlin.playground

/**
 * @author Andreas Keefer
 *
 * - while and do while loops are the same as in java!
 * - no classic for loop like in java exists in kotlin: for (int i = 0; i < 10; i++)
 */
fun main() {
    // range operator
    val range = 1..5 // 1 and 5 are inclusive
    val charRange = 'a'..'z'
    val stringRange = "ABC".."XYZ"
    val backwardRange = 5.downTo(1) // range in reverse order

    println(6 in range)
    println('x' in charRange)
    println("CCC" in stringRange)
    println("CCCC" in stringRange)
    println("Y" in stringRange)

    for (i in range.step(2)) {
        println(i)
    }

    for (i in range.reversed()) {
        println(i)
    }

    for (c in 'a'..'m' step 5) {
        println(c)
    }

    for (i in 10 downTo 2 step 2) {
        println(i)
    }

    // index based for loop
    val array = arrayOf("A", "B", "C")
    for (index in array.indices) {
        println("${array[index]} has index $index")
    }
    // with lambda
    array.forEachIndexed { index, value -> println("$value has index $index") }


    // named loops
    for (i in 1..2) {
        println("i = $i")
        jloop@ for (j in 2..3) {
            println("j = $j")
            for (k in 3..5) {
                println("k = $k")
                if (k == 4) {
                    // break the outer j loop
                    break@jloop
                }
            }
        }
    }

    // using extension function below to iterate over string range
    for (i in "a".."x") {
        println(i)
    }
}

// extension function for ClosedRange<String> to be able to use string range in a for loop (x in "a".."x")
operator fun ClosedRange<String>.iterator(): Iterator<String> =
        // this is just a demo and makes no sense like this :D
        listOf(this.start, this.endInclusive)
                .iterator()