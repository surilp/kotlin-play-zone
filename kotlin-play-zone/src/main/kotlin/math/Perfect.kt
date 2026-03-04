package `kotlin-play-zone`.src.main.kotlin.math

import kotlin.math.sqrt

fun isPerfect(n: Int): Boolean{
    var result = 1

    for (num in 2 ..sqrt(n.toDouble()).toInt()){
        if (n % num == 0) {
            result += num
            val divisionResult = n / num
            if (divisionResult != num) {
                result += n / num
            }
        }
    }

    return result == n
}

fun main() {
    val input = listOf(6, 4, 28, 36)
    input.forEach {
        println("For input $it, result is ${isPerfect(it)}")
    }
}
