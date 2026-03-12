package `kotlin-play-zone`.src.main.kotlin.binarysearch

fun rotatedSortedArrayII(nums: IntArray, k: Int): Boolean {
    val size = nums.size
    var start = 0
    var end = size - 1


    while (start <= end) {
        val mid = (start + end) / 2
        val midNum = nums[mid]

        if (k == midNum) {
            return true
        } else if (midNum == nums[end] && midNum == nums[start]) {
            end -= 1
            start += 1
        } else if (nums[start] <= midNum) {
            if (nums[start] <= k && k <= midNum) {
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

    return false
}

fun main() {
    val input = listOf(
        Pair(intArrayOf(7, 8, 1, 2, 3, 3, 3, 4, 5, 6), 3),
        Pair(intArrayOf(7, 8, 1, 2, 3, 3, 3, 4, 5, 6), 10),
        Pair(intArrayOf(7, 8, 1, 2, 3, 3, 3, 4, 5, 6), 7),
        Pair(intArrayOf(3, 1, 2, 3, 3, 3, 3), 2),
    )

    input.forEach {
        println(
            "For input ${it.first.contentToString()}, ${it.second}, result is ${
                rotatedSortedArrayII(
                    it.first,
                    it.second
                )
            }"
        )
    }
}
