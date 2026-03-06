package `kotlin-play-zone`.src.main.kotlin.string

fun palindromeCheck(s: String): Boolean {
    var start = 0
    var end = s.length - 1

    while (start < end) {
        if (s[start] != s[end]) {
            return false
        }
        start++
        end--
    }

    return true
}

fun main() {
    val input = listOf(
        "hannah",
        "aabbaaa",
        "aabbccbbaa"
    )

    input.forEach {
        println("For input $it result is ${palindromeCheck(it)}")
    }
}
