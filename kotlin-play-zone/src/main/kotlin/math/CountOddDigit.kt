package `kotlin-play-zone`.src.main.kotlin.math

fun countOddDigit(n: Int): Int {
    var num = n
    var count = 0

    while(num != 0) {
        val currentNum = num % 10
        if (currentNum % 2 != 0) {
            count++
        }
        num /= 10
    }
    return count
}

fun main() {
    val input = listOf<Int>(5,25,15)
    input.forEach {
        println("For input $it the result is ${countOddDigit(it)}")
    }
}