package `kotlin-play-zone`.src.main.kotlin.math

fun reverseNumber(n: Int): Int {
    var num = n
    var result = 0

    while (num != 0) {
        val currentNum = num % 10
        result = (result * 10) + currentNum
        num /= 10
    }

    return result
}

fun main() {
    val input = listOf(25, 123 , 54)
    input.forEach {
        println("For input $it result is ${reverseNumber(it)}")
    }
}
