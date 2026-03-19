package `kotlin-play-zone`.src.main.kotlin.greedyalgorithms

fun jobScheduling(jobs: Array<IntArray>): IntArray {
    val sorted = jobs.sortedWith { a, b ->
        when {
            a[2] < b[2] -> 1
            a[2] > b[2] -> -1
            else -> 0
        }
    }

    var jobs = 0
    var profit = 0

    val maxDays: Int = sorted.maxBy {
        it[1]
    }[1]

    val daysArray = IntArray(maxDays + 1)

    for (item in sorted) {
        val cJobId = item[0]
        val cDeadLine = item[1]
        val cProfit = item[2]

        var temp = cDeadLine

        while (temp > 0 && daysArray[temp] != 0) {
            temp--
        }

        if (temp <= 0) {
            continue
        }
        daysArray[temp] = cJobId
        jobs++
        profit += cProfit
    }


    return intArrayOf(jobs, profit)
}

fun main() {
    val input = listOf(
        arrayOf(
            intArrayOf(1, 4, 20),
            intArrayOf(2, 1, 10),
            intArrayOf(3, 1, 40),
            intArrayOf(4, 1, 30),
        ),
        arrayOf(
            intArrayOf(1, 2, 100),
            intArrayOf(2, 1, 19),
            intArrayOf(3, 2, 27),
            intArrayOf(4, 1, 25),
            intArrayOf(5, 1, 15),
        ),
        arrayOf(
            intArrayOf(1, 1, 100),
            intArrayOf(2, 2, 200),
            intArrayOf(3, 3, 300),
            intArrayOf(4, 4, 400),
        ),
    )

    input.forEach {
        println(jobScheduling(it).contentToString())
    }
}
