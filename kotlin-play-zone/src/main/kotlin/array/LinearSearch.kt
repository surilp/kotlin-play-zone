package `kotlin-play-zone`.src.main.kotlin.array

fun linearSearch(nums: IntArray, target: Int): Int {
    nums.forEachIndexed { i, value ->
        if (value == target) {
            return i
        }
    }
    return -1
}

fun main() {
    val input = listOf(
        Pair(intArrayOf(2, 3, 4, 5, 3), 3),
        Pair(intArrayOf(2, -4, 4, 0, 10), 6),
        Pair(intArrayOf(1, 3, 5, -4, 1), 1),
    )

    input.forEach {
        println("For input, ${it.first.contentToString()}, result is ${linearSearch(it.first, it.second)}")
    }
}
