package `kotlin-play-zone`.src.main.kotlin.sorting

fun bubbleSort(nums: IntArray): IntArray {
    val n = nums.size

    for (i in 0 until n) {
        for (j in 1 until n - i) {
            if (nums[j] < nums[j - 1]) {
                nums[j] = nums[j-1].also { nums[j-1] = nums[j] }
            }
        }
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
        println("For input ${it.contentToString()}, result is ${bubbleSort(it).contentToString()}")
    }
}
