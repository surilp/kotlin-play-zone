package `kotlin-play-zone`.src.main.kotlin.string

fun largestOddNum(s: String): String {
    var start = 0
    var end = s.length - 1

    while(s[start] == '0') {
        start++
    }

    while(s[end].digitToInt() % 2 == 0) {
        end--
    }

    return s.substring(start, end+1)
}

fun main() {
    val input = listOf(
        "5347",
        "0214638",
        "0032579"
    )

    input.forEach {
        println("For input $it, result is ${largestOddNum(it)}")
    }
}
