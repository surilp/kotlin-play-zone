package `kotlin-play-zone`.src.main.kotlin.twopointers

fun longestOnes(nums: IntArray, k: Int): Int {
    var tempK = 0

    var l = 0
    var r = 0
    val n = nums.size

    var maxSize = 0
    while (r < n) {
        if (nums[r] == 0) {
            tempK++

            if (tempK > k) {
                if (nums[l] == 0) {
                    tempK--
                }
                l++
            }
        }

        if (tempK <= k) {
            maxSize = maxOf(maxSize, r - l + 1)
        }

        r++
    }

    return maxSize
}

fun main() {
    val input = listOf(
        Pair(intArrayOf(1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0), 3),
        Pair(intArrayOf(0, 0, 1, 1, 1, 0, 1, 1, 1, 0, 0, 0, 0, 1, 1, 1, 1), 3),
        Pair(intArrayOf(1, 1, 0, 0, 1), 3),
        Pair(intArrayOf(0, 1, 1, 0, 1), 1),
    )

    input.forEach {
        println(longestOnes(it.first, it.second))
    }
}