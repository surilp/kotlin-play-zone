package `kotlin-play-zone`.src.main.kotlin.binarysearch

fun findPeakGrid(mat: Array<IntArray>): Pair<Int,Int> {
    val colSize = mat.size
    val rowSize = mat[0].size
    var start = 0
    var end = rowSize - 1

    while (start <= end) {
        val mid = (start + end) / 2

        val colMaxIndex = findColMax(mat, mid)

        val top = if (colMaxIndex == 0) {
            -1
        } else {
            mat[colMaxIndex - 1][mid]
        }

        val bottom = if(colMaxIndex == rowSize - 1) {
            -1
        } else {
            mat[colMaxIndex + 1][mid]
        }

        val left = if (mid == 0) {
            -1
        } else {
            mat[colMaxIndex][mid - 1]
        }

        val right = if (mid == colSize - 1) {
            -1
        } else {
            mat[colMaxIndex][mid + 1]
        }

        val currentVal = mat[colMaxIndex][mid]
        if (currentVal > top && currentVal > bottom && currentVal > left && currentVal > right) {
            return Pair(colMaxIndex, mid)
        }

        if (left > currentVal) {
            end = mid - 1
        } else if (right > currentVal) {
            start = mid + 1
        }
    }

    return Pair(-1, -1)
}

fun findColMax(mat: Array<IntArray>, colIndex: Int): Int {
    val rowSize = mat.size
    var maxIndex = 0
    var max = mat[0][colIndex]
    for (row in 0 until rowSize) {
        if (mat[row][colIndex] > max) {
            max = mat[row][colIndex]
            maxIndex = row
        }
    }

    return maxIndex
}

fun main() {
    val input = listOf(
        arrayOf(
            intArrayOf(10, 20, 15),
            intArrayOf(21, 30, 14),
            intArrayOf(7, 16, 32),
        ),
        arrayOf(
            intArrayOf(10, 7),
            intArrayOf(11, 17),
        ),
        arrayOf(
            intArrayOf(1, 2, 3),
            intArrayOf(4, 5, 6),
            intArrayOf(7, 8, 9),
        ),
    )

    input.forEach {
        println("result is ${findPeakGrid(it)}")
    }
}
