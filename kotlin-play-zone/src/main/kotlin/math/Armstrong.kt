package `kotlin-play-zone`.src.main.kotlin.math

import kotlin.math.pow

fun isArmstrong(n: Int): Boolean {
    var result: Double = 0.0
    var num = n

    while(num > 0) {
        val currentDigit = num % 10
        val powerThree = currentDigit.toDouble().pow(3)
        result += powerThree
        num /= 10
    }

    return result.toInt() == n
}

fun main() {
    val input = listOf(153, 12, 370)

    input.forEach {
        println("For input $it, the result is ${isArmstrong(it)}")
    }
}
