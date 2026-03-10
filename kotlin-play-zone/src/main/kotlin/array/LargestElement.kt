package `kotlin-play-zone`.src.main.kotlin.array

fun largestElement(nums: IntArray): Int {
    var max = Int.MIN_VALUE

    for (num in nums) {
        if (num > max) {
            max = num
        }
    }

    return max
}

fun main() {
    val input = listOf(
        intArrayOf(3, 3, 6, 1),
        intArrayOf(3, 3, 0, 99, -40),
        intArrayOf(-4, -3, 0, 1, -8)
    )

    input.forEach {
        println("For input ${it.contentToString()}, result is ${largestElement(it)}")
    }
}
