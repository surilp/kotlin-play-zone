package `kotlin-play-zone`.src.main.kotlin.twopointers

fun kDistanceChar(s: String, k: Int): Int {
    // aababbcaacc

    val map = HashMap<Char, Int>()
    var l = 0
    var r = 0

    val n = s.length
    var result = 0
    while (r < n) {
        val char = s[r]

        map[char] = map.getOrDefault(char, 0) + 1

        if (map.size > k) {
            map[s[l]] = map[s[l]]!! - 1
            if (map[s[l]] == 0) {
                map.remove(s[l])
            }
            l++
        }

        if (map.size <= k) {
            result = maxOf(result, r - l + 1)
        }

        r++
    }

    return result
}

fun main() {
    val input = listOf(
        Pair("aababbcaacc", 2),
        Pair("abcddefg", 3),
        Pair("abccab", 4),
    )

    input.forEach {
        println(kDistanceChar(it.first, it.second))
    }
}
