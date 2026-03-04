package `kotlin-play-zone`.src.main.kotlin.math

fun isPalindrome(n: Int): Boolean {
    var num = n
    var newN = 0

    while(num != 0) {
        val currentDigit = num % 10
        newN = newN * 10 + currentDigit
        num /= 10
    }

    return newN == n
}

fun main() {
    val input = listOf<Int>(121, 123, 101)
    input.forEach {
        println("For input $it, result is ${isPalindrome(it)}")
    }
}