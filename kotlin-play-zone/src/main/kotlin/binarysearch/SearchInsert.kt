package `kotlin-play-zone`.src.main.kotlin.binarysearch

fun searchInsert(nums: IntArray, target: Int): Int {
    var result = nums.size
    var start = 0
    var end = nums.size - 1

    while (start <= end) {
        println("start $start and $end")
        val mid = (start + end) / 2
        if (target == nums[mid]) {
            return mid
        } else if (target > nums[mid]) {
            start = mid + 1
        } else {
            result = mid
            end = mid - 1
        }
    }
    return result
}

fun main() {
    val input = listOf(
        Pair(intArrayOf(1, 3, 5, 6), 5),
        Pair(intArrayOf(1, 3, 5, 6), 2),
        Pair(intArrayOf(1, 3, 5, 6), 7),
    )

    input.forEach {
        println("For input ${it.first.contentToString()}, ${it.second}, result is ${searchInsert(it.first, it.second)}")
    }
}