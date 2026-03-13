package `kotlin-play-zone`.src.main.kotlin.binarysearch

fun minRateToEatBananas(nums: IntArray, h:Int): Int {
    val n = nums.size

    if (n > h) {
        return -1
    }

    var start = 1
    var end = nums.max()

    var result = 0

    while (start <= end) {
        val mid = (start + end) / 2

        val sum = helper(nums, mid)

        if (sum == h) {
            result = mid
            break
        } else if (sum > h) {
            start = mid + 1
        } else {
            end = mid - 1
            result = mid
        }

    }

    return result
}

fun helper(nums: IntArray, div: Int): Int {
    var sum = 0

    for (num in nums){
        sum += (num + div - 1) / div
    }
    return sum
}


fun main() {
    val input = listOf(
        Pair(intArrayOf(7, 15, 6, 3), 8),
        Pair(intArrayOf(25, 12, 8, 14, 19), 5),
        Pair(intArrayOf(3, 7, 6, 11), 8),
    )

    input.forEach {
        println(
            "For input ${it.first.contentToString()}, ${it.second}, result is ${
                minRateToEatBananas(
                    it.first,
                    it.second
                )
            }"
        )
    }
}
