package `kotlin-play-zone`.src.main.kotlin.array

fun reverse(arr: List<Int>, n: Int): List<Int> {
    val result = IntArray(n)

    for (index in 0 until n) {
        result[index] = arr[n - index - 1]
    }

    return result.toList()
}

fun reverse2(arr: IntArray, n: Int) {
    for (index in 0 until n/2) {
        arr[index] = arr[n-index-1].also { arr[n-index-1] = arr[index] }
    }
}

fun main() {
    val input = listOf(1, 2, 3, 4, 5)
    println("For input $input result is ${reverse(input, input.size)}")

    val input2 = intArrayOf(1,2,3,4)
    reverse2(input2, input2.size)
    println("For input $input result of reverse 2 is ${input2.toList()}")
}
