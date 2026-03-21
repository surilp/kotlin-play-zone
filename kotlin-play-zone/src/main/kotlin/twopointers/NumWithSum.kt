package `kotlin-play-zone`.src.main.kotlin.twopointers

fun numWithSum(nums: IntArray, goal: Int): Int {
    val map = HashMap<Int, Int>()
    map[0] = 1

    var sum = 0
    var result = 0
    for (num in nums) {
        sum += num
        val diff = sum - goal

        if (diff in map) {
            result += map[diff] ?: 0
        }
        map[sum] = map.getOrDefault(sum, 0) + 1
    }

    return result
}

fun main() {
    val input = listOf(
        Pair(intArrayOf(1, 1, 0, 1, 0, 0, 1), 3),
        Pair(intArrayOf(0, 0, 0, 0, 1), 0),
    )

    input.forEach {
        println(numWithSum(it.first, it.second))
    }
}