package `kotlin-play-zone`.src.main.kotlin.binarysearch

fun matrixMedian(matrix: Array<IntArray>): Int {
    val colSize = matrix[0].size
    val rowSize = matrix.size

    var start = findMin(matrix)
    var end = findMax(matrix)

    var result = 0
    val numOfElements = (colSize * rowSize) / 2
    while (start <= end) {
        val mid = (start + end) / 2

        if (count(matrix, mid) > numOfElements) {
            end = mid - 1
            result = mid
        } else {
            start = mid + 1
        }

    }
    return result
}

fun count(matrix: Array<IntArray>, mid: Int): Int {
    var sum = 0

    for (nums in matrix) {
       sum += upperBoundCount(nums,mid)
    }

    return sum
}

fun upperBoundCount(nums: IntArray, num: Int): Int {
    var start = 0
    var end = nums.size - 1

    while (start <= end) {
        val mid = (start + end) / 2

        if (nums[mid] == num) {
            start = mid + 1
        } else if (num > nums[mid]) {
            start = mid + 1
        } else {
            end = mid - 1
        }

    }

    return if (start < 0) {
        0
    } else {
        start
    }
}

fun findMin(matrix: Array<IntArray>): Int {
    val rowSize = matrix.size
    var result = matrix[0][0]

    for (row in 0 until rowSize) {
       if (matrix[row][0] < result) {
           result = matrix[row][0]
       }
    }

    return result
}

fun findMax(matrix: Array<IntArray>): Int {
    val rowSize = matrix.size
    val colSize = matrix[0].size

    var result = matrix[0][colSize - 1]

    for (row in 0 until rowSize) {
        if (matrix[row][colSize - 1] > result) {
            result = matrix[row][colSize - 1]
        }
    }

    return result
}

fun main() {
    val input = listOf(
        arrayOf(
            intArrayOf(1, 5, 7, 9, 11),
            intArrayOf(2, 3, 4, 5, 10),
            intArrayOf(9, 10, 12, 14, 16),
        ),
        arrayOf(
            intArrayOf(1, 4, 9),
            intArrayOf(2, 5, 6),
            intArrayOf(3, 7, 8),
        ),
        arrayOf(
            intArrayOf(1, 3, 8),
            intArrayOf(2, 3, 4),
            intArrayOf(1, 2, 5),
        ),
        arrayOf(
            intArrayOf(1, 4, 15),
            intArrayOf(2, 5, 6),
            intArrayOf(3, 8, 11),
        ),
    )

    input.forEach {
        println("result is ${matrixMedian(it)}")
    }
}
