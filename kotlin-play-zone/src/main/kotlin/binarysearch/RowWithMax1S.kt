package `kotlin-play-zone`.src.main.kotlin.binarysearch

fun rowWithMax1s(mat: Array<IntArray>): Int {
    if (mat.isEmpty() || mat[0].isEmpty()) {
        return -1
    }

    val rowSize = mat.size

    var result = -1
    var tempCount = 0

    for ((i, row) in mat.withIndex()) {
        val count = countOfOne(row, rowSize)
        println("row $i count $count")
        if (count > tempCount) {
            result = i
            tempCount = count
        } else if (tempCount <= result) {
            return result
        }

    }

    return result
}

fun countOfOne(nums: IntArray, n: Int): Int {
    var start = 0
    var end = n - 1

    var result = -1
    while(start <= end) {
        val mid = (start + end) / 2

        if (nums[mid] == 1) {
            result = mid
            end = mid - 1
        } else {
            start = mid + 1
        }
    }

    if (result == -1) {
        return 0
    } else {
        return n - result
    }
}

fun main() {
    val input = listOf(
        arrayOf(
            intArrayOf(1, 1, 1),
            intArrayOf(0, 0, 1),
            intArrayOf(0, 0, 0),
        ),
        arrayOf(
            intArrayOf(0, 0),
            intArrayOf(0, 0),
        ),
        arrayOf(
            intArrayOf(0, 0, 1),
            intArrayOf(0, 1, 1),
            intArrayOf(0, 1, 0),
        ),
    )

    input.forEach {
        println("result is ${rowWithMax1s(it)}")
    }
}
