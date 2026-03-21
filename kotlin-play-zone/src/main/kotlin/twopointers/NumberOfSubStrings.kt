package `kotlin-play-zone`.src.main.kotlin.twopointers

fun numberOfSubStrings(s: String): Int {
    val n = s.length

    var result = 0

    for (i in 0 until n){
        val set = HashSet<Char>()
        for (j in i until n) {
            set.add(s[j])
            if (set.size >= 3) {
                result += n - j
                break
            }
        }
    }

    return result
}

fun main() {
    val input = listOf(
        "abcba",
        "ccabcc",
        "abccba"
    )

    input.forEach {
        println(numberOfSubStrings(it))
    }
}