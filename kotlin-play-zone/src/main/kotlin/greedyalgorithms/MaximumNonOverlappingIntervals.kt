package `kotlin-play-zone`.src.main.kotlin.greedyalgorithms

fun maximumNonOverlappingIntervals(intervals: Array<IntArray>): Int {
    val sorted = intervals.sortedBy { it[1] }

    var count = 0
    var previousIntervalEndTime = -1

    for (item in sorted) {
        val s = item[0]
        val e = item[1]

        if (s >= previousIntervalEndTime) {
            count++
            previousIntervalEndTime = e
        }
    }

    return intervals.size - count
}

fun main() {
    val input = listOf(
        arrayOf(
            intArrayOf(1,2),
            intArrayOf(2,3),
            intArrayOf(3,4),
            intArrayOf(1,3),
        ),
        arrayOf(
            intArrayOf(1,3),
            intArrayOf(1,4),
            intArrayOf(3,5),
            intArrayOf(3,4),
            intArrayOf(4,5),
        ),
        arrayOf(
            intArrayOf(1,10),
            intArrayOf(1,4),
            intArrayOf(3,8),
            intArrayOf(3,4),
            intArrayOf(4,5),
        ),
    )

    input.forEach {
        println(maximumNonOverlappingIntervals(it))
    }
}