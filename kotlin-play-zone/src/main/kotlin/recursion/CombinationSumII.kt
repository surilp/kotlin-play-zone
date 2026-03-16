package `kotlin-play-zone`.src.main.kotlin.recursion

fun combinationSumII(candidates: IntArray, target: Int): List<IntArray> {
    val result = mutableListOf<IntArray>()
    val ds = mutableListOf<Int>()
    val n = candidates.size

    val sortedCandidates = candidates.sorted()

    fun helper(
        candidates: List<Int>,
        target: Int,
        result: MutableList<IntArray>,
        ds: MutableList<Int>,
        n: Int,
        current: Int,
        sum: Int
    ) {
        if (sum > target || current > n) {
            return
        }

        if (current == n) {
            if (sum == target) {
                result.add(ds.toIntArray())
            }
            return
        }

        ds.add(candidates[current])
        helper(candidates, target,result, ds, n, current + 1, sum + candidates[current])
        ds.removeLast()

        var temp = current
        val currentVal = candidates[current]
        while (temp < n && candidates[temp]  == currentVal) {
            temp++
        }
        helper(candidates, target, result, ds, n, temp, sum)
    }

    helper(sortedCandidates, target, result, ds, n, 0, 0)

    return result
}

fun main() {
    val input = listOf(
        Pair(intArrayOf(2, 1, 2, 7, 6, 1, 5), 8),
        Pair(intArrayOf(2, 5, 2, 1, 2), 5),
        Pair(intArrayOf(2, 1, 2), 5),
    )

    input.forEach { arr ->
        println("For input ${arr.first.contentToString()}, ${arr.second}, result is ")
        combinationSumII(arr.first, arr.second).forEach {
            println(it.contentToString())
        }
        println("End of result")

    }
}