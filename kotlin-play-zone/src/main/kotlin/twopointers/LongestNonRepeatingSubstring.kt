package `kotlin-play-zone`.src.main.kotlin.twopointers

fun longestNonRepeatingSubstring(s: String): Int {
    val map = HashMap<Char, Int>()

    var l = 0
    var r = 0
    val n = s.length

    var maxLength = 0
    while (r < n) {
//        println("start left $l right $r")
        val letter: Char = s[r]
        if (letter !in map) {
            map[letter] = r
            maxLength = maxOf(r - l + 1, maxLength)
            r++
        } else {
            val pos = map[letter]!!
            if (pos < l) {
                map[letter] = r
                maxLength = maxOf(r - l + 1, maxLength)
                r++
            } else {
                l = pos + 1
            }
        }
//        println("End left $l right $r")
    }

    return maxLength
}

fun main() {
    val input = listOf(
        "abcddabac",
        "aaabbbccc",
        "aaaa"
    )

    input.forEach {
        println(longestNonRepeatingSubstring(it))
    }
}