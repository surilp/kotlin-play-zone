package `kotlin-play-zone`.src.main.kotlin.math

fun largestDigit(n: Int): Int {
    var num = n
    var result = 0

    while(num != 0) {
        val currentDigit = num % 10
        result = maxOf(currentDigit, result)
        num /= 10
    }

    return result
}

fun main() {
    val input = listOf<Int>(25, 99, 1)
    input.forEach {
        println("For input $it result is ${largestDigit(it)}")
    }
}
