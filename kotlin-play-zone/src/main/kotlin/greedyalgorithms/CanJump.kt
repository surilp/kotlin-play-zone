package `kotlin-play-zone`.src.main.kotlin.greedyalgorithms

fun canJump(nums:IntArray): Boolean {
    if (nums.isEmpty()) {
        return false
    }

    var max = 0
    var i = 0
    val n = nums.size

    while (i < n) {
//        println("i $i max $max jump ${nums[i]}")
        if (i > max) {
            return false
        }
        val jump = nums[i]
        max = maxOf(max, jump + i)

        i++
    }
    return true
}

fun main() {
    val input = listOf(
        intArrayOf(2, 3, 1, 1, 4),
        intArrayOf(3, 2, 1, 0, 4),
        intArrayOf(5, 3, 2, 1, 0),
    )

    input.forEach {
        println("For input ${it.contentToString()}, result is ${canJump(it)}")
    }
}