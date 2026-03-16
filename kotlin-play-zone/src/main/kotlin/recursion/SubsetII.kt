package `kotlin-play-zone`.src.main.kotlin.recursion

fun subsetsII(nums: IntArray): List<IntArray> {
    val n =nums.size
    val ds = mutableListOf<Int>()
    val result = mutableListOf<IntArray>()

    fun helper(nums: IntArray, ds: MutableList<Int>, result: MutableList<IntArray>, current: Int, n: Int) {
        if (current == n) {
            result.add(ds.toIntArray())
            return
        }

        ds.add(nums[current])
        helper(nums, ds, result, current+ 1, n)
        ds.removeLast()

        var temp = current
        while(temp < n && nums[current] == nums[temp]) {
            temp++
        }

        helper(nums, ds, result, temp, n)
    }

    helper(nums, ds, result, 0, n)

    return result
}

fun main() {
    val input = listOf(
        intArrayOf(1, 2, 2),
        intArrayOf(1, 2),
        intArrayOf(1, 3, 3),
    )

    input.forEach {
        println("For input ${it.contentToString()}")
        val result = subsetsII(it)
        println("result is")
        result.forEach { println(it.contentToString()) }

    }
}