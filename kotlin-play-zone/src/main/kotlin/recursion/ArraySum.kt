package `kotlin-play-zone`.src.main.kotlin.recursion

fun arraySum(nums: IntArray): Int {
    fun helper(nums: IntArray, i:Int, n: Int): Int {
        if (i >= n) {
            return 0
        }
        return nums[i] + helper(nums, i + 1, n)
    }

    return helper(nums, 0, nums.size)
}

fun main() {
    val input = listOf(
        intArrayOf(1,2,3),
        intArrayOf(5,8,1),
        intArrayOf(12,9,17)
    )

    input.forEach {
        println("For input $it, result is ${arraySum(it)}")
    }
}
