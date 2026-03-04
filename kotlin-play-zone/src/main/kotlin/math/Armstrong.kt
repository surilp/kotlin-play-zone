package `kotlin-play-zone`.src.main.kotlin.math

import kotlin.math.pow
import kotlin.math.log10

fun isArmstrong(n: Int): Boolean {
    var result: Double = 0.0
    var num = n
    val count = log10(n.toDouble()) + 1

    while(num > 0) {
        val currentDigit = num % 10
        val powerThree = currentDigit.toDouble().pow(count.toInt())
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
