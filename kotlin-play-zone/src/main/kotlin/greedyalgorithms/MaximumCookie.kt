package `kotlin-play-zone`.src.main.kotlin.greedyalgorithms

fun findMaximumCookieStudents(student: IntArray, cookie: IntArray): Int {
    val sortedStudent = student.sortedDescending()
    val sortedCookie = cookie.sortedDescending()

    val sN = sortedStudent.size
    val cN = sortedCookie.size

    var sI = 0
    var cI = 0

    var result = 0
    while (sI < sN && cI < cN) {
        val sValue = sortedStudent[sI]
        val cValue = sortedCookie[cI]

        if (sValue <= cValue) {
            result++
            sI++
            cI++
        } else {
            sI++
        }
    }

    return result
}

fun main() {
    val input = listOf(
        Pair(intArrayOf(1, 2, 3), intArrayOf(1, 1)),
        Pair(intArrayOf(1, 2), intArrayOf(1, 2, 3)),
        Pair(intArrayOf(4, 5, 1), intArrayOf(6, 4, 2)),
    )

    input.forEach {
        println(
            "For input ${it.first.contentToString()}, ${it.second.contentToString()}, result is ${
                findMaximumCookieStudents(
                    it.first,
                    it.second
                )
            }"
        )
    }
}