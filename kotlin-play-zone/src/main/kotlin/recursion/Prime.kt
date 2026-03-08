package `kotlin-play-zone`.src.main.kotlin.recursion

import kotlin.math.sqrt

fun checkPrime(num: Int): Boolean {
    val n = sqrt(num.toFloat()).toInt()

    fun helper(i: Int, n: Int, num: Int): Boolean {
        if (i > n) {
            return true
        }

        if (num % i == 0) {
            return false
        }

        return helper(i + 1, n, num)
    }

    return helper(2, n, num)
}

fun main() {
    val input = listOf(
        5,
        15,
        41
    )

    input.forEach {
        println("For input $it, result is ${checkPrime(it)}")
    }
}
