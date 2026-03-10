package `kotlin-play-zone`.src.main.kotlin.array

fun rotateArrayByOne(nums: IntArray): IntArray {
    val first = nums[0]
    val size = nums.size

    for (i in 1 until size) {
        nums[i-1] = nums[i]
    }

    nums[size - 1] = first
    return nums
}

fun main() {
    val input = listOf(
        intArrayOf(1, 2, 3, 4, 5),
        intArrayOf(-1, 0, 3, 6),
        intArrayOf(7, 6, 5, 4),
    )

    input.forEach {
        println("For input ${it.contentToString()} result is ${rotateArrayByOne(it).contentToString()}")
    }
}
