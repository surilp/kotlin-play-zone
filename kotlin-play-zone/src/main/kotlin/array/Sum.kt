package `kotlin-play-zone`.src.main.kotlin.array

fun sum(arr: List<Int>, n: Int): Int {
    var result = 0

    for(index in 0 until n) {
        result += arr[index]
    }

    return result
}

fun main() {
    val input = listOf(1, 2, 3, 4, 5)
    println("For input $input result is ${sum(input, input.size)}")

    val input2 = listOf(1, 2, 1, 1, 5, 1)
    println("For input $input result is ${sum(input2, input2.size)}")
}
