package `kotlin-play-zone`.src.main.kotlin.binarysearch

fun getFloorAndCeil(nums: IntArray, x: Int): IntArray {
    val size = nums.size
    var start = 0
    var end = size - 1
    var floor = -1
    var ceil = -1
    while (start <= end) {
        val mid = (start + end) / 2
        val midNum = nums[mid]

        if (x == midNum) {
            floor = midNum
            ceil = midNum
            return intArrayOf(floor, ceil)
        } else if (x > midNum) {
            floor = midNum
            start = mid + 1
        } else {
            ceil = midNum
            end = mid - 1
        }
    }

    return intArrayOf(floor, ceil)

}

fun main() {
    val input = listOf(
        Pair(intArrayOf(3, 4, 4, 7, 8, 10), 5),
        Pair(intArrayOf(3, 4, 4, 7, 8, 10), 8),
        Pair(intArrayOf(2, 4, 6, 8, 10, 12, 14), 1),
        Pair(intArrayOf(10, 20, 30, 40, 50), 25),
    )

    input.forEach {
        println(
            "For input ${it.first.contentToString()}, ${it.second}, result is ${
                getFloorAndCeil(
                    it.first,
                    it.second
                ).contentToString()
            }"
        )
    }
}
