package `kotlin-play-zone`.src.main.kotlin.binarysearch

fun firstAndLastOccurrence(nums: IntArray, x: Int): IntArray {
    var first = -1
    var last = -1
    val size = nums.size
    var start = 0
    var end = size - 1

    while (start <= end) {
        val mid = (start + end) / 2
        val midNum = nums[mid]

        if (midNum == x) {
            first = mid
            end = mid - 1
        } else if (x < midNum) {
            end = mid - 1
        } else {
            start = mid + 1
        }
    }

    start = 0
    end = size - 1

    while (start <= end) {
        val mid = (start + end) / 2
        val midNum = nums[mid]

        if (midNum == x) {
            last = mid
            start = mid + 1
        } else if (x < midNum) {
            end = mid - 1
        } else {
            start = mid + 1
        }
    }


    return intArrayOf(first, last)

}

fun main() {
    val input = listOf(
        Pair(intArrayOf(5, 7, 7, 8, 8, 10), 8),
        Pair(intArrayOf(5, 7, 7, 8, 8, 10), 6),
        Pair(intArrayOf(5, 7, 7, 8, 8, 10), 5),
    )

    input.forEach {
        println(
            "For input ${it.first.contentToString()}, ${it.second}, result is ${
                firstAndLastOccurrence(
                    it.first,
                    it.second
                ).contentToString()
            }"
        )
    }
}
