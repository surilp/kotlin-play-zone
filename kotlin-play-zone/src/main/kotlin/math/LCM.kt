package `kotlin-play-zone`.src.main.kotlin.math

fun LCM(n1: Int, n2: Int): Int {
    return ((n1 * n2) / GCD(n1, n2))
}

fun main() {
    val input = listOf(Pair(5, 3), Pair(4, 6), Pair(4, 12))
    input.forEach {
        println("For input $it, result is ${LCM(it.first, it.second)}")
    }
}