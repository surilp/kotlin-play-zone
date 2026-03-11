package `kotlin-play-zone`.src.main.kotlin.hasing

fun longestSubarray(nums: IntArray, k: Int): Int {
    val n = nums.size

    fun brute(nums: IntArray, k: Int, n: Int): Int {
        var result = 0

        for (i in 0 until n) {
            var sum = nums[i]
            if (sum == k) {
                result = maxOf(result, 1)
            }
            for (j in i + 1 until n) {
                sum += nums[j]
                if (sum == k) {
                    result = maxOf(result, j-i + 1)
                }
            }
        }

        return result
    }

    fun optimal(nums: IntArray, k: Int, n: Int): Int {
        val map = HashMap<Int, MutableList<Int>>()
        val prefixSumList = mutableListOf<Int>()
        var prefixSum = 0
        nums.forEachIndexed { index, i ->
            prefixSum += i
            prefixSumList.add(prefixSum)
            map[prefixSum] = map.getOrDefault(prefixSum, mutableListOf())
            map[prefixSum]?.add(index)
        }

        var result = 0


        for ((i, num) in prefixSumList.withIndex()) {
            val target = num - k

            if (target == 0) {
                result = maxOf(result, i + 1)
            } else {
                if (target in map) {
                    val indexList = map[target]!!
                    for (index in indexList) {
                        if (index <= i) {
                            result = maxOf(result, i -index)
                        }
                    }
                }
            }

        }

        return result
    }

    return optimal(nums, k, n)
}

fun main() {
    val input = listOf(
        Pair(intArrayOf(10, 5, 2, 7, 1, 9), 15),
        Pair(intArrayOf(-3, 2, 1), 6),
        Pair(intArrayOf(-1, 1, 1), 1),
        Pair(intArrayOf(2, 0, 0, 3), 3),
    )

    input.forEach {
        println(
            "For input ${it.first.contentToString()}, ${it.second}, result is ${
                longestSubarray(
                    it.first,
                    it.second
                )
            }"
        )
    }
}
