package `kotlin-play-zone`.src.main.kotlin.recursion

fun isSorted(nums: IntArray): Boolean {
    fun helper(nums: IntArray, i: Int, n: Int): Boolean {
        if (i >= n) {
            return true
        }

        if (nums[i] < nums[i-1]) {
            return false
        }

        return helper(nums, i + 1, n)
    }

    return helper(nums, 1, nums.size)
}

fun main() {
    val input = listOf(
        intArrayOf(1, 2, 3, 4, 5),
        intArrayOf(1, 2, 1, 4, 5),
        intArrayOf(1,9,6,8,5,4,0)
    )

    input.forEach {
        println("For input ${it.contentToString()}, result is ${isSorted(it)}")
    }
}
