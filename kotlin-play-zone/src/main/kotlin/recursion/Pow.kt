package `kotlin-play-zone`.src.main.kotlin.recursion

import kotlin.math.abs

fun pow(x: Double, n: Int): Double {
    fun helper(x: Double, n: Int): Double {
        if (n == 0) {
            return 1.0
        }

        return x * pow(x, n - 1)
    }

    val result = helper(x, abs(n))

    return if (n < 0) {
        1 / result
    } else {
        result
    }
}

fun pow2(x: Double, n: Int): Double {
    fun helper(x: Double, n: Int): Double {
        if (n == 0) {
            return 1.0
        }

        if (n % 2 == 0) {
            return pow2(x * x, n / 2)
        } else {
            return x * pow2(x, n - 1)
        }
    }

    val result = helper(x, abs(n))

    return if (n < 0) {
        1 / result
    } else {
        result
    }

}

fun main() {
    // Example 1
    println("%.4f".format(pow2(2.0, 10)))   // Output: 1024.0000

    // Example 2
    println("%.4f".format(pow2(2.0, -2)))   // Output: 0.2500

    // Example 3
    println("%.4f".format(pow2(2.5, 2)))    // Output: 6.2500

    println("%.4f".format(pow2(-2.0, 3)))    // Output: 6.2500
}
