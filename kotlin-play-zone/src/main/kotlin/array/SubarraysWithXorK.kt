package `kotlin-play-zone`.src.main.kotlin.array

fun subarraysWithXorK(nums: IntArray, k: Int): Int {
    val map = HashMap<Int, Int>()
    map[0] = 1
    var count = 0
    var xorVal = 0
    for (num in nums) {
        xorVal = xorVal xor num
        val target = xorVal xor k
        count += (map[target] ?: 0)
        map[xorVal] = (map[xorVal] ?: 0) + 1
    }
    return count
}

fun main() {
    val input = listOf(
        Pair(intArrayOf(4, 2, 2, 6, 4), 6),
        Pair(intArrayOf(5, 6, 7, 8, 9), 5),
        Pair(intArrayOf(5, 2, 9), 7),

    )

    input.forEach {
        println(
            "For input ${it.first.contentToString()}, ${it.second}, result is ${
                subarraysWithXorK(
                    it.first,
                    it.second
                )
            }"
        )
    }
}
