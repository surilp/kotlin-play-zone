package `kotlin-play-zone`.src.main.kotlin.recursion

fun subsetsI(nums: IntArray): IntArray {
    val result = mutableListOf<Int>()
    val n = nums.size

    fun helper(nums: IntArray, sum: Int, current: Int, n: Int) {
        if (current == n) {
            result.add(sum)
            return
        }

        helper(nums, sum, current + 1, n)

        helper(nums, sum + nums[current], current + 1, n)
    }

    helper(nums, 0, 0, n)
    return result.toIntArray()
}

fun main() {
    val input = listOf(
        intArrayOf(2, 3),
        intArrayOf(5, 2, 1),
        intArrayOf(1),
    )

    input.forEach {
        val result = subsetsI(it)
        println("For each input ${it.contentToString()}, result is ${result.contentToString()}")
    }
}