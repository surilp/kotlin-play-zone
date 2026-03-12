package `kotlin-play-zone`.src.main.kotlin.binarysearch

fun rotatedSortedArray(nums: IntArray, k:Int): Int {
    val size = nums.size
    var start = 0
    var end = size - 1


    while (start <= end) {
        val mid = (start + end) / 2
        val midNum = nums[mid]

        if (k == midNum) {
            return mid
//        } else if (nums[start] < nums[end]) {
//            if (k > midNum) {
//                start = mid + 1
//            } else {
//                end = mid - 1
//            }
        } else if (nums[start] <= midNum) {
            if (nums[start] <= k &&  k <= midNum) {
                end = mid - 1
            } else {
                start = mid + 1
            }
        } else {
            if (midNum <= k && k <= nums[end]) {
                start = mid + 1
            } else {
                end = mid - 1
            }
        }
    }

    return -1
}

fun main() {
    val input = listOf(
        Pair(intArrayOf(4, 5, 6, 7, 0, 1, 2), 0),
        Pair(intArrayOf(4, 5, 6, 7, 0, 1, 2), 3),
        Pair(intArrayOf(4, 5, 6, 7, 0, 1, 2), 5),
    )

    input.forEach {
        println("For input ${it.first.contentToString()}, ${it.second}, result is ${rotatedSortedArray(it.first, it.second)}")
    }
}