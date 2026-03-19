package `kotlin-play-zone`.src.main.kotlin.greedyalgorithms

fun maxMeeting(start: IntArray, end: IntArray): Pair<List<Pair<Int, Int>>, Int> {
    val meetingTime = start.zip(end).sortedBy { it.second }


    var prevMeetingEndTime = -1
    val result = mutableListOf<Pair<Int, Int>>()

    for (item in meetingTime) {
        val s = item.first
        val e = item.second

        if (s > prevMeetingEndTime) {
            result.add(Pair(s,e))
            prevMeetingEndTime = e
        }
    }

    return Pair(result, result.count())

}

fun main() {
    val input = listOf(
        Pair(intArrayOf(1, 3, 0, 5, 8, 5), intArrayOf(2, 4, 6, 7, 9, 9)),
        Pair(intArrayOf(10, 12, 20), intArrayOf(20, 25, 30)),
        Pair(intArrayOf(1, 4, 6, 9), intArrayOf(2, 5, 7, 12)),
    )

    input.forEach {
        println(maxMeeting(it.first, it.second))
    }
}
