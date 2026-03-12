package `kotlin-play-zone`.src.main.kotlin.binarysearch

fun findMin(nums: IntArray): Int {
    val size = nums.size
    var start = 0
    var end = size - 1

    var result = Int.MAX_VALUE

    while (start <= end) {
        val mid = (start + end) / 2
        val midNum = nums[mid]

        if (nums[start] <= midNum) {
            result = minOf(nums[start], result)
            start = mid + 1
        } else {
            result =  minOf(midNum, result)
            end = mid - 1
        }
    }

    return result
}

fun main() {
    val input = listOf(
        intArrayOf(4, 5, 6, 7, 0, 1, 2, 3),
        intArrayOf(3, 4, 5, 1, 2),
        intArrayOf(4, 5, 6, 7, -7, 1, 2, 3),
    )

    input.forEach {
        println("For input ${it.contentToString()}, result is ${findMin(it)}")
    }
}
