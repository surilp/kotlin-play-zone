package `kotlin-play-zone`.src.main.kotlin.array

fun secondLargestElement(nums: IntArray): Int {
    if (nums.isEmpty()) {
        return -1
    }

    var max = nums[0]
    var second = -1

    for (i in 1 until nums.size) {
        if (nums[i] > max) {
            second = max
            max = nums[i]
        } else if (nums[i] > second && max != nums[i]) {
            second = nums[i]
        }
    }

    return second
}

fun main() {
    val input = listOf(
        intArrayOf(8, 8, 7, 6, 5),
        intArrayOf(10, 10, 10, 10, 10),
        intArrayOf(7, 7, 2, 2, 10, 10, 10),
    )

    input.forEach {
        println("For input ${it.contentToString()} result is ${secondLargestElement(it)}")
    }
}
