package `kotlin-play-zone`.src.main.kotlin.recursion

fun reverseArray(nums: IntArray): IntArray {
    fun helper(nums: IntArray, start: Int, end: Int) {
        if (start >= end) {
            return
        }

        nums[start] = nums[end].also { nums[end] = nums[start] }
        helper(nums, start + 1, end - 1)
    }

    helper(nums, 0, nums.size - 1)
    return nums
}


fun main() {
    val input = listOf(
        intArrayOf(1, 2, 3, 4, 5),
        intArrayOf(1, 3, 3, 3, 5),
        intArrayOf(1, 2, 1)
    )

    input.forEach {
        println("For input ${it.contentToString()}, result is ${reverseArray(it).contentToString()}")
    }
}
