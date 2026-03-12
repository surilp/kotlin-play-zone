package `kotlin-play-zone`.src.main.kotlin.binarysearch

fun singleNonDuplicate(nums: IntArray): Int {
    val size = nums.size
    var start = 0
    var end = nums.size - 1


    if (nums[0] != nums[1]) {
        return nums[0]
    }

    if (nums[size - 1] != nums[size-2]) {
        return nums[size - 1]
    }

    while (start <= end) {
        val mid = (start + end) / 2

        if (nums[mid] != nums[mid + 1] && nums[mid] != nums[mid - 1]) {
            return nums[mid]
        }

        if (mid % 2 == 0) {
            if (nums[mid] == nums[mid + 1]) {
                start = mid + 1
            } else {
                end = mid - 1
            }

        } else {
            if (nums[mid] == nums[mid - 1]) {
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
        intArrayOf(1, 1, 2, 2, 3, 3, 4, 5, 5, 6, 6),
        intArrayOf(1, 1, 3, 5, 5),
        intArrayOf(1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6, 7)
    )

    input.forEach {
        println("For input ${it.contentToString()}, result is ${singleNonDuplicate(it)}")
    }
}
