package `kotlin-play-zone`.src.main.kotlin.recursion

fun combinationSum(candidates: IntArray, target: Int): List<IntArray> {
    val result = mutableListOf<IntArray>()
    val n = candidates.size
    val ds = mutableListOf<Int>()

    fun helper(
        candidates: IntArray,
        target: Int,
        n: Int,
        result: MutableList<IntArray>,
        ds: MutableList<Int>,
        current: Int,
        sum: Int
    ) {
        if (sum > target || current >= n) {
            return
        }

        if (sum == target) {
            result.add(ds.toIntArray())
            return
        }

        ds.add(candidates[current])
        helper(candidates, target, n, result, ds, current,sum + candidates[current])
        ds.removeLast()


        helper(candidates, target, n, result, ds, current + 1, sum)
    }

    helper(candidates, target, n, result, ds, 0, 0)
    return result
}

fun main() {
    val input = listOf(
        Pair(intArrayOf(2, 3, 5, 4), 7),
        Pair(intArrayOf(2), 1),
        Pair(intArrayOf(3, 4, 5, 6), 10),
    )

    input.forEach {
        println("For input ${it.first.contentToString()}, ${it.second}, result is ")
        combinationSum(it.first, it.second).forEach {
            println(it.contentToString())
        }
        println("End of result")

    }
}
