package `kotlin-play-zone`.src.main.kotlin.recursion

fun permutation1(nums: IntArray): List<IntArray> {
    val n = nums.size
    val result = mutableListOf<IntArray>()
    val ds = mutableListOf<Int>()
    val set = HashSet<Int>()

    fun helper(
        nums: IntArray, n: Int, set: HashSet<Int>, ds: MutableList<Int>, result: MutableList<IntArray>
    ) {
        if (ds.size == n) {
            result.add(ds.toIntArray())
            return
        }

        for (i in 0 until n) {
            if (i !in set) {
                set.add(i)
                ds.add(nums[i])
                helper(nums, n, set, ds, result)
                set.remove(i)
                ds.removeLast()
            }
        }
    }

    helper(nums, n, set, ds, result)
    return result.toList()
}

fun main() {
    val input = listOf(
        intArrayOf(1, 2, 3, 4, 5)
    )

    input.forEach {
        println("for input ${it.contentToString()}")
        println("Result is")
        permutation1(it).forEach { println(it.contentToString()) }
    }
}