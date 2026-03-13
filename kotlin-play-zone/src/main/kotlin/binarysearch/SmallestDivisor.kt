package `kotlin-play-zone`.src.main.kotlin.binarysearch

fun smallestDivisor(nums: IntArray, limit: Int): Int {
    var start = 1
    var end = nums.max()

    var result = -1
    while (start <= end) {
        val mid = (start + end) / 2
        val temp = divideSum(nums, mid)

        if (temp == limit) {
            return mid
        } else if (temp > limit) {
            start = mid + 1
        } else {
            end = mid - 1
            result = mid
        }
    }

    return result
}


fun divideSum(nums: IntArray, divisor: Int): Int {
    var sum = 0

    for (num in nums) {
        sum += (num + divisor - 1) / divisor
    }

    return sum
}

fun main() {
    val input = listOf(
        Pair(intArrayOf(1, 2, 3, 4, 5), 8),
        Pair(intArrayOf(8,4,2,3), 10),
        Pair(intArrayOf(8,4,2,3), 4),
    )

    input.forEach {
        println("For input ${it.first.contentToString()}, ${it.second}, result is ${smallestDivisor(it.first, it.second)}")
    }

}
