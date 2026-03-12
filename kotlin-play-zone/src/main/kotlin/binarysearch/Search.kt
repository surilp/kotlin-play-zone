package `kotlin-play-zone`.src.main.kotlin.binarysearch

fun binarySearch(nums: IntArray, target: Int): Int {
    var start = 0
    var end = nums.size - 1

    while (start <= end) {
        val mid = (start + end) / 2
        if (nums[mid] == target) {
            return mid
        } else if (nums[mid] > target) {
            end = mid - 1
        } else {
            start = mid + 1
        }
    }

    return -1
}

fun recursiveBinarySearch(nums: IntArray, target: Int): Int {

    fun helper(nums: IntArray, target: Int, start: Int, end: Int): Int {
        if (start > end) {
            return -1
        }

        val mid = (start + end) / 2
        val midNum = nums[mid]

        return if (midNum == target) {
            mid
        } else if (target < midNum) {
            helper(nums, target, start, mid - 1)
        } else {
            helper(nums, target, mid + 1, end)
        }
    }

    return helper(nums, target, 0, nums.size - 1)
}

fun main() {
    val input = listOf(
        Pair(intArrayOf(-1, 0, 3, 5, 9, 12), 9),
        Pair(intArrayOf(-1, 0, 3, 5, 9, 12), 2),
        Pair(intArrayOf(-1, 0, 3, 5, 9, 12), -1),
    )

    input.forEach {
        println("For input ${it.first.contentToString()}, ${it.second}, result is ${binarySearch(it.first, it.second)}")
    }
    println()
    input.forEach {
        println("For input ${it.first.contentToString()}, ${it.second}, result is ${recursiveBinarySearch(it.first, it.second)}")
    }
}
