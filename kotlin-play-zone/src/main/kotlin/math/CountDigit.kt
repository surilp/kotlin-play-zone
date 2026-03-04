package `kotlin-play-zone`.src.main.kotlin.math

class CountDigit {
    fun solve(n: Int):Int {
        var number = n

        var result = 0
        while(number != 0) {
            number = number / 10
            result++
        }
        return result
    }
}

fun main() {
    val input = listOf(4, 14, 234)
    val countDigit = CountDigit()

    for (item in input) {
        println("Input is $item and result is ${countDigit.solve(item)}")
    }
}