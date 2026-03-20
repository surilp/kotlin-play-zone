package `kotlin-play-zone`.src.main.kotlin.twopointers

fun longestNonRepeatingSubstring(s: String): Int {
    val map = HashMap<Char, Int>()

    var i = 0
    val n = s.length

    var currentLength = 0
    var maxLength = 0
    while (i < n) {
        val letter: Char = s[i]
        if (letter !in map) {
            map[letter] = i
            currentLength++
            maxLength = maxOf(currentLength, maxLength)
        } else {
            val pos = map[letter]!!
            currentLength = i - pos
            map[letter] = i
        }

        i++
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