package `kotlin-play-zone`.src.main.kotlin.binarysearch

fun lowerBound(nums: IntArray, x: Int): Int {
    var start = 0
    var end = nums.size - 1

    if (x > nums[end]) {
        return nums.size
    }

    var result = -1
    while (start <= end) {
        val mid = (start + end) / 2

        if (x <= nums[mid]) {
            result = mid
            end = mid - 1
        } else if (x > nums[mid]) {
            start = mid + 1
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
        println("For input ${it.first.contentToString()}, ${it.second}, result is ${lowerBound(it.first, it.second)}")
    }
}
