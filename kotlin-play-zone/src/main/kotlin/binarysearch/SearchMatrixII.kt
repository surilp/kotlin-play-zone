package `kotlin-play-zone`.src.main.kotlin.binarysearch

fun searchMatrixII(matrix: Array<IntArray>, target: Int): Pair<Int, Int> {
    val rowSize = matrix[0].size
    val columnSize = matrix.size

    var row = 0
    var col = rowSize - 1


    while (row in 0..<rowSize && col in 0..<columnSize) {
        val value = matrix[row][col]

        if (value == target) {
            return Pair(row, col)
        } else if (target < value) {
            col--
        } else {
            row ++
        }
    }

    return Pair(-1, -1)
}

fun main() {
    val input = listOf(
        Pair(
            arrayOf(
                intArrayOf(1, 4, 7, 11, 15),
                intArrayOf(2, 5, 8, 12, 19),
                intArrayOf(3, 6, 9, 16, 22),
                intArrayOf(10, 13, 14, 17, 24),
                intArrayOf(18, 21, 23, 26, 30),
            ), 5
        ),
        Pair(
            arrayOf(
                intArrayOf(1, 4, 7, 11, 15),
                intArrayOf(2, 5, 8, 12, 19),
                intArrayOf(3, 6, 9, 16, 22),
                intArrayOf(10, 13, 14, 17, 24),
                intArrayOf(18, 21, 23, 26, 30),
            ), 14
        ),
        Pair(
            arrayOf(
                intArrayOf(1, 4, 7, 11, 15),
                intArrayOf(2, 5, 8, 12, 19),
                intArrayOf(3, 6, 9, 16, 22),
                intArrayOf(10, 13, 14, 17, 24),
                intArrayOf(18, 21, 23, 26, 30),
            ), 1
        ),
    )

    input.forEach {
        println("result is ${searchMatrixII(it.first, it.second)}")
    }
}
