package `kotlin-play-zone`.src.main.kotlin.binarysearch

fun findRotation(nums: IntArray): Int {
    val size = nums.size
    var start = 0
    var end = size - 1

    var minNum = Int.MAX_VALUE
    var minIndex = -1

    while(start <= end) {
        val mid = (start + end) / 2

        if (nums[start] <= nums[mid]) {
            if (nums[start] < minNum) {
                minNum = nums[start]
                minIndex = start
            }
            start = mid + 1
        } else {
            if (nums[mid] < minNum) {
                minNum = nums[end]
                minIndex = mid
            }
            end = mid - 1
        }
    }
    return minIndex
}

fun main() {
    val input = listOf(
        intArrayOf(4, 5, 6, 7, 0, 1, 2, 3),
        intArrayOf(3, 4, 5, 1, 2),
        intArrayOf(4, 5, 1, 2),
    )

    input.forEach {
        println("For input ${it.contentToString()}, result is ${findRotation(it)}")
    }
}
