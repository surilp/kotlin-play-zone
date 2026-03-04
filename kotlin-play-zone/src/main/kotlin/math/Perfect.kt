package `kotlin-play-zone`.src.main.kotlin.math

fun isPerfect(n: Int): Boolean{
    var result = 0

    for (num in n-1 downTo 1 ){
        if (n % num == 0) {
            result += num
        }
    }

    return result == n
}

fun main() {
    val input = listOf(6, 4, 28)
    input.forEach {
        println("For input $it, result is ${isPerfect(it)}")
    }
}
