package `kotlin-play-zone`.src.main.kotlin.array

fun subArraySum(nums: IntArray, k: Int): Int {
    val map = HashMap<Int, Int>()
    map[0] = 1
    var prefixSum = 0
    var result = 0
    for (num in nums) {
        prefixSum += num

        val target = prefixSum - k
        if (target in map) {
            result++
        }

        map[prefixSum] = map.getOrDefault(prefixSum, 0)
        map[prefixSum] = (map[prefixSum] ?: 0) + 1
    }

    return result
}


fun main() {
    val input = listOf(
        Pair(intArrayOf(10, 5, 2, 7, 1, 9), 15),
        Pair(intArrayOf(1, 1, 1), 2),
        Pair(intArrayOf(1, 2, 3), 3),
        Pair(intArrayOf(3, 1, 2, 4), 6),
        Pair(intArrayOf(-3, 2, 1), 6),
        Pair(intArrayOf(-1, 1, 1), 1),
        Pair(intArrayOf(2, 0, 0, 3), 3),
        Pair(intArrayOf(1, 2, 3, 1, 1, 1, 1, 3, 3), 6),
        Pair(intArrayOf(1, 2, 3, -3, 1, 1, 1, 4, 2, -3), 3),
    )

    input.forEach {
        println(
            "For input ${it.first.contentToString()}, ${it.second}, result is ${
                subArraySum(
                    it.first,
                    it.second
                )
            }"
        )
    }
}