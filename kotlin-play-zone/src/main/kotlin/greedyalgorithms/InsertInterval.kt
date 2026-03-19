package `kotlin-play-zone`.src.main.kotlin.greedyalgorithms

fun insertInterval(intervals: Array<IntArray>, newInterval: IntArray): List<IntArray> {

    var start = -1
    var end = -1

    val nS = newInterval[0]
    val nE = newInterval[1]

    val result = mutableListOf<IntArray>()

    for ((i, interval) in intervals.withIndex()) {
        val cS = interval[0]
        val cE = interval[1]

        if (start == -1) {
            if (nS in cS..cE) {
                start = i
            }
        }

        if (end == -1) {
            if (nE in cS..cE) {
                end = i
            }
        }

        if (start != -1 && end == -1) {
            if (cS > nE) {
                result.add(intArrayOf(intervals[start][0], nE))
                start = -1
            }
        }

        if (start == -1 && end != -1) {
            if (nE < cS) {
                result.add(intArrayOf(nS, intervals[end][1]))
                end = -1
            }
        }

        if (start == -1 && end == -1) {
            result.add(interval)
        }

        if (start != -1 && end != -1) {
            result.add(intArrayOf(intervals[start][0], intervals[end][1]))
            start = -1
            end = -1
        }
    }


    return result.toList()
}

fun main() {
    val input = listOf(
        Pair(arrayOf(intArrayOf(1, 3), intArrayOf(6, 9)), intArrayOf(2, 5)),
        Pair(arrayOf(intArrayOf(1, 2), intArrayOf(3, 5), intArrayOf(6, 7), intArrayOf(8, 10)), intArrayOf(4, 8)),
        Pair(arrayOf(intArrayOf(1, 2), intArrayOf(3, 5), intArrayOf(6, 7), intArrayOf(8, 10)), intArrayOf(1, 8)),

    )

    input.forEach {
        println("start")
        insertInterval(it.first, it.second).forEach { println(it.contentToString()) }
        println("end")
    }
}