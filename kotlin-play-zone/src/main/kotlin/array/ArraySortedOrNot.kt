package `kotlin-play-zone`.src.main.kotlin.array

fun arraySortedOrNot(arr: IntArray, n: Int): Boolean {
    for (i in 1 until n) {
        if (arr[i] < arr[i-1]) {
            return false
        }
    }
    return true
}

fun main() {
    val input = intArrayOf(1,2,3,4,5)
    println("For input ${input.contentToString()}, result is ${arraySortedOrNot(input, input.size)}")
}