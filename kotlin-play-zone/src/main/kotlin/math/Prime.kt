package `kotlin-play-zone`.src.main.kotlin.math

import kotlin.math.sqrt

fun isPrime(n:Int): Boolean {
    if (n == 0) {
        return false
    }

    var result = true

    for (num in 2..sqrt(n.toDouble()).toInt()) {
        if (n % num == 0) {
            result = false
            break
        }
    }

    return result
}

fun main() {
    val input = listOf(5, 8, 9)
    input.forEach {
        println("For input $it, result is ${isPrime(it)}")
    }
}