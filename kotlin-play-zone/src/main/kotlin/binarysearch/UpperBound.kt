package `kotlin-play-zone`.src.main.kotlin.binarysearch

fun upperBound(nums: IntArray, x: Int): Int {
    val size = nums.size
    var result = size

    var start = 0
    var end = size - 1

    while (start <= end) {
        val mid = (start + end) / 2
        val midNum = nums[mid]

        if (x == midNum) {
            start = mid + 1
        } else if (x > midNum) {
            start = mid + 1
        } else {
            end = mid - 1
            result = mid
        }
    }

    return result
}

fun main() {
    val input = listOf(
        Pair(intArrayOf(1,2,2,3), 2),
        Pair(intArrayOf(3,5,8,15,19), 9),
        Pair(intArrayOf(3,5,8,15,19), 3),
    )

    input.forEach {
        println("For input ${it.first.contentToString()}, ${it.second}, result is ${upperBound(it.first, it.second)}")
    }
}
