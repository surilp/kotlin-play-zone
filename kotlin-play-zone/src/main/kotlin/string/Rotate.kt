package `kotlin-play-zone`.src.main.kotlin.string

fun isRotateString(s: String, goal: String): Boolean {
    val sLength = s.length
    val gLength = goal.length

    if (sLength != gLength) {
        return false
    }

    var sCounter = 0
    while (sCounter < sLength) {
        if (s[sCounter] != goal[0]) {
            sCounter++
        }
        var counter = 0
        var sIndex = sCounter
        while (counter < gLength) {
            if (goal[counter] == s[sIndex%sLength]) {
                if (counter == gLength - 1) {
                    return true
                }
                counter++
                sIndex++
            } else {
                break
            }
        }

        sCounter++
    }
    return false
}

fun main() {
    val input = listOf(
        Pair("abcde", "cdeab"),
        Pair("abcde", "adeac"),
        Pair("abcde", "abcde"),
        Pair("abadfadfdfaadfccxdag","aadfccxdagabadfadfdf")
    )

    input.forEachIndexed {i,item ->
        println("For input ${input[i]} result is ${isRotateString(item.first, item.second)} ")
    }
}