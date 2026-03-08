package `kotlin-play-zone`.src.main.kotlin.recursion

fun fib(n: Int): Int {
    if (n == 0 || n == 1) {
        return n
    }

    return fib(n-1) + fib(n-2)
}

fun main() {
    val input = listOf(
        2,3,6
    )

    input.forEach {
        println("For input $it, result is ${fib(it)}")
    }
}
