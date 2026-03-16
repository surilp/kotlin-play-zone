package `kotlin-play-zone`.src.main.kotlin.recursion

fun countSubSequenceWithTargetSum(nums: IntArray, k: Int): Int {
    val n = nums.size

    fun helper(nums: IntArray, k:Int, n: Int, current: Int, sum: Int): Int {
        if (sum > k) {
            return 0
        }
        if (current == n) {
            if (sum == k) {
                return 1
            } else {
                return 0
            }
        }

        var result = 0
        result += helper(nums, k, n, current + 1, sum + nums[current])
        result += helper(nums, k , n, current + 1, sum)

        return result
    }

    return helper(nums, k, n, 0, 0)
}

fun main() {
    val input = listOf(
        Pair(intArrayOf(4, 9, 2, 5, 1), 10),
        Pair(intArrayOf(4, 2, 10, 5, 1, 3), 5),
        Pair(intArrayOf(1, 10, 4, 5), 16),
    )

    input.forEach {
        println("For input ${it.first}, ${it.second}, result is ${countSubSequenceWithTargetSum(it.first, it.second)}")
    }
}
