package `kotlin-play-zone`.src.main.kotlin.array

fun countOdd(arr: List<Int>, n: Int): Int {
    var result = 0
    for (index in 0 until n) {
        val num = arr[index]
        if (num % 2 != 0) {
            result += 1
        }
    }
    return result
}

fun main() {
    val input = listOf(1, 2, 3, 4, 5)
    println("For input $input result is ${countOdd(input, input.size)}")
}