package `kotlin-play-zone`.src.main.kotlin.math

import kotlin.math.sqrt

fun GCD(n1: Int, n2: Int): Int {
    var num1: Int
    var num2: Int

    if (n1 > n2) {
        num1 = n1 % n2
        num2 = n2
    } else {
        num1 = n2 % n1
        num2 = n1
    }

    while(num1 > 0 && num2 > 0) {
        if(num1 > num2) {
            num1 -= num2
        } else if(num2 > num1) {
            num2 -= num1
        } else {
            return num1
        }
    }

    return maxOf(num1, num2)
}

fun main() {
    val input = listOf(Pair(4, 6), Pair(35, 10))
    input.forEach {
        println("For input $it, the result is ${GCD(it.first, it.second)}")
    }
}