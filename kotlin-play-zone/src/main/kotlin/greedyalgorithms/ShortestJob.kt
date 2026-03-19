package `kotlin-play-zone`.src.main.kotlin.greedyalgorithms

fun shortestJob(bt: IntArray): Int {

    if (bt.size == 1) {
        return bt[0]
    }
    val sorted = bt.sorted()

    var sum = 0
    var result = 0
    var i = 1
    val n = sorted.size

    while (i < n) {
        sum = sorted[i-1] + sum

        result += sum

        i++
    }

    return result / n
}

fun main() {
    val input = listOf(
        intArrayOf(4, 1, 3, 7, 2),
        intArrayOf(1, 2, 3, 4),
        intArrayOf(9, 3, 1, 8, 2),
    )

    input.forEach {
        println("For input ${it.contentToString()} result is ${shortestJob(it)}")
    }
}
