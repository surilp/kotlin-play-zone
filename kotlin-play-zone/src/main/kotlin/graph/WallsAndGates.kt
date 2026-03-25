package `kotlin-play-zone`.src.main.kotlin.graph

fun shortestDistance(matrix: Array<CharArray>, rowI: Int, colI: Int): Pair<Pair<Int, Int>, Int> {
    val rSize = matrix.size
    val cSize = matrix[0].size

    val visited = Array(rSize) { IntArray(cSize) }

    var minDistance = Int.MAX_VALUE
    var target = Pair(-1, -1)
    fun helper(rowS: Int, colS: Int, distance: Int, firstBlock: Boolean = false) {
        if (rowS < 0 || rowS >= rSize || colS < 0 || colS >= cSize || distance >= minDistance) {
            return
        }
        if (matrix[rowS][colS] == 'X' && !firstBlock) {
            return
        }
        if (matrix[rowS][colS] == 'D') {
            if (minDistance > distance) {
                minDistance = distance
                target = Pair(rowS, colS)
            }

            return
        }

        visited[rowS][colS] = 1
        helper(rowS + 1, colS, distance + 1)
        helper(rowS, colS + 1, distance + 1)
        helper(rowS - 1, colS, distance + 1)
        helper(rowS, colS - 1, distance + 1)
        visited[rowS][colS] = 0
    }

    helper(rowI, colI, 0, true)

    return if (minDistance == Int.MAX_VALUE) {
        Pair(target,-1)
        Pair(target,-1)
    } else {
        Pair(target,minDistance)
    }
}

fun shortestDistance2(matrix: Array<CharArray>):HashMap<Pair<Int, Int>, Int> {
    val rowN = matrix.size
    val colN = matrix[0].size
    val result = HashMap<Pair<Int, Int>, Int>()

    for (i in 0 until rowN) {
        for (j in 0 until colN) {
            if (matrix[i][j] == 'C') {
                val min = shortestDistance(matrix, i, j)
                val target = min.first
                result[target] = result.getOrDefault(target, 0) + 1
            }
        }
    }

    return result
}

fun main() {
    val input = arrayOf(
        charArrayOf( '_','_','X','X','X','_','D'),
        charArrayOf( '_','_','_','X','_','_','_'),
        charArrayOf( '_','D','_','_','_','_','D'),
    )

    println(shortestDistance(input, 0, 0))
    println(shortestDistance(input, 1, 1))
    println(shortestDistance(input, 2, 1))
    println(shortestDistance(input, 0, 2))
    println(shortestDistance(input, 0, 3))


    val input2 = arrayOf(
        charArrayOf( 'C','_','X','X','X','_','D'),
        charArrayOf( '_','C','_','X','_','C','C'),
        charArrayOf( '_','D','_','C','_','_','D'),
    )

    println(shortestDistance2(input2))
}