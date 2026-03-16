package `kotlin-play-zone`.src.main.kotlin.recursion

fun checkSubSequenceSum(nums: IntArray, k: Int): Boolean {
    val n = nums.size

    fun helper(nums: IntArray, k: Int, current: Int, n:Int, sum: Int): Boolean {
        if(current == n) {
            return sum == k
        }

        val res = helper(nums, k, current + 1, n, sum + nums[current])

        if (res) {
            return true
        }

        return helper(nums, k, current+1, n, sum)
    }

    return helper(nums, k, 0, n, 0)

}


fun main() {
    val input = listOf(
        Pair(intArrayOf(1,2,3,4,5), 8),
        Pair(intArrayOf(4, 3, 9, 2), 10),
        Pair(intArrayOf(1, 10, 4, 5), 16),
    )

    input.forEach {
        println("For input ${it.first}, ${it.second}, result is ${checkSubSequenceSum(it.first, it.second)}")
    }
}
