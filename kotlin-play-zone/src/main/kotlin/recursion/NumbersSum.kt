package `kotlin-play-zone`.src.main.kotlin.recursion

fun numbersSum(n: Int):Int {
    if (n == 0) {
        return 0
    }
    return n + numbersSum(n - 1)
}

fun main() {
    val input = listOf(
        4,
        2,
        10
    )

    input.forEach {
        println("For input $it, result is ${numbersSum(it)}")
    }
}
