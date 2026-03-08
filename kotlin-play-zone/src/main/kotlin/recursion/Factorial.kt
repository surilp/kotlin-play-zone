package `kotlin-play-zone`.src.main.kotlin.recursion

fun factorial(n:Int): Int {
    if (n == 0) {
        return 1
    }

    return n * factorial(n-1)
}

fun main() {
    val input = listOf(
        3,
        5,
        4
    )

    input.forEach {
        println("for input $it, result is ${factorial(it)}")
    }
}
