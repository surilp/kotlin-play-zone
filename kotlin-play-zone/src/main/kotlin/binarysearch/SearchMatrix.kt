package `kotlin-play-zone`.src.main.kotlin.binarysearch

fun searchMatrix(mat: Array<IntArray>, target: Int): Pair<Int, Int> {
    if (mat.isEmpty() || mat[0].isEmpty()) {
        return Pair(-1, -1)
    }

    val colSize = mat.size
    val rowSize = mat[0].size

    val colIndex = binarySearch(mat, 0, colSize - 1, target, true, -1)
    if (colIndex == -1) {
        return Pair(-1, -1)
    }

    val rowIndex = binarySearch(mat, start = 0, rowSize - 1, target, false, colIndex)

    if (rowIndex == -1) {
        return Pair(-1, -1)
    }

    return Pair(colIndex, rowIndex)
}

fun binarySearch(mat: Array<IntArray>, start: Int, end: Int, target: Int, isCol: Boolean, row:Int): Int {
    var result = -1

    var s = start
    var e = end

    if (isCol) {
        while (s <= e) {
            val mid = (s + e) / 2

            if (mat[mid][0] == target) {
                result = mid
                break
            } else if (target > mat[mid][0]) {
                result = mid
                s = mid + 1
            } else {
                e = mid - 1
            }
        }
    } else {
        while (s <= e) {
            val mid = (s + e) / 2

            if (mat[row][mid] == target) {
                result = mid
                break
            } else if (target > mat[row][mid]) {
                s = mid + 1
            } else {
                e = mid - 1
            }
        }
    }

    return result
}

fun main() {
    val input = listOf(
        Pair(
            arrayOf(
                intArrayOf(1, 2, 3, 4),
                intArrayOf(5, 6, 7, 8),
                intArrayOf(9, 10, 11, 12),
            ), 8
        ),
        Pair(
            arrayOf(
                intArrayOf(1, 2, 4),
                intArrayOf(6, 7, 8),
                intArrayOf(9, 10, 34),
            ), 78
        ),
        Pair(
            arrayOf(
                intArrayOf(1, 2, 4),
                intArrayOf(6, 7, 8),
                intArrayOf(9, 10, 34),
            ), 7
        ),
    )

    input.forEach {
        println("result is ${searchMatrix(it.first, it.second)}")
    }
}
