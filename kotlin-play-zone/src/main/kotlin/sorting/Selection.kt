package `kotlin-play-zone`.src.main.kotlin.sorting

fun selectionSort(nums: IntArray): IntArray {
    val n = nums.size

    for (i in 0 until n-1) {
        var minIndex = i
        for (j in i + 1 until n) {
            if (nums[minIndex] > nums[j]) {
                minIndex = j
            }
        }
        nums[i] = nums[minIndex].also { nums[minIndex] = nums[i] }
    }

    return nums
}

fun main() {
    val input = listOf(
        intArrayOf(7, 4, 1, 5, 3),
        intArrayOf(5, 4, 4, 1, 1),
        intArrayOf(3, 2, 3, 4, 5),
    )

    input.forEach {
        println("For input ${it.contentToString()}, result is ${selectionSort(it).contentToString()}")
    }
}
