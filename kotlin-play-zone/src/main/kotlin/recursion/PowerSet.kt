package `kotlin-play-zone`.src.main.kotlin.recursion

fun powerSet(nums: IntArray): List<IntArray> {
    val ds = mutableListOf<Int>()
    val result = mutableListOf<IntArray>()
    val size = nums.size

    fun helper(nums: IntArray, ds: MutableList<Int>, result: MutableList<IntArray>, n:Int, current: Int) {
        if (current == n) {
            result.add(ds.toIntArray())
            return
        }

        ds.add(nums[current])
        helper(nums, ds, result, n, current + 1)
        ds.removeLast()

        helper(nums, ds, result, n, current + 1)
    }

    helper(nums, ds, result, size, 0)
    return result
}


fun main() {
    val nums = intArrayOf(1,2,3)
    val result = powerSet(nums)
    result.forEach { println(it.contentToString()) }
}
