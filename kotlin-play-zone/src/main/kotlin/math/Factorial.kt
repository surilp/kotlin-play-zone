package `kotlin-play-zone`.src.main.kotlin.math

fun factorial(n: Int): Int {
    var result = 1
    var counter = n

    while(counter > 0) {
        result *= counter
        counter--
    }

    return result
}

fun main() {
    val input = listOf(0, 1, 2, 3, 4)

    input.forEach {
        println("For input $it result is ${factorial(it)}")
    }
}