package `kotlin-play-zone`.src.main.kotlin.recursion

fun combinationSumIII(k: Int, n: Int):List<IntArray> {
    val result = mutableListOf<IntArray>()
    val nums = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9)
    val ds = mutableListOf<Int>()

    fun helper(current: Int, sum: Int) {

        if (sum > n || current >= nums.size) {
            return
        }

        if (ds.size == k) {
            if (sum == n) {
                result.add(ds.toIntArray())
            }
            return
        }

        ds.add(nums[current])
        helper(current + 1, sum + nums[current])
        ds.removeLast()

        helper(current + 1, sum)
    }

    helper(0, 0)
    return result
}

fun main() {
    val input = listOf(
        Pair(3,7),
        Pair(3,9),
        Pair(3,8),
    )

    input.forEach {
        println("For input ${it.first}, ${it.second}")
        val result = combinationSumIII(it.first, it.second)
        println("Result is")
        result.forEach { println(it.contentToString()) }
    }
}
