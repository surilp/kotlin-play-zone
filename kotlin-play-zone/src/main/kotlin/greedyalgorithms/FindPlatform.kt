package `kotlin-play-zone`.src.main.kotlin.greedyalgorithms

fun findPlatform(arrival: IntArray, departure: IntArray): Int {
    val sortedArrival = arrival.sorted()
    val sortedDeparture = departure.sorted()

    var max = 0
    var tempMax = 0

    var i = 0
    var j = 0

    while (i < sortedArrival.size && j < sortedDeparture.size) {
        if (sortedArrival[i] <= sortedDeparture[j]) {
            tempMax += 1
            max = maxOf(max, tempMax)
            i++
        } else
        {
            tempMax -= 1
            j++
        }
    }

    return max
}

fun main() {
    val input = listOf(
        Pair(
            intArrayOf(900, 940, 950, 1100, 1500, 1800),
            intArrayOf(910, 1200, 1120, 1130, 1900, 2000)
        ),
        Pair(
            intArrayOf(900, 1100, 1235),
            intArrayOf(1000, 1200, 1240)
        ),
        Pair(
            intArrayOf(900, 1000, 1200),
            intArrayOf(1000, 1200, 1240)
        ),
    )

    input.forEach {
        println(findPlatform(it.first, it.second))
    }
}