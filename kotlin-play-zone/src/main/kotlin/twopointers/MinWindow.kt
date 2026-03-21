package `kotlin-play-zone`.src.main.kotlin.twopointers

import kotlin.math.min

fun minWindow(s: String, t: String): String {
    val tSet = t.toSet()
    val n = s.length

    var l = 0
    var r = 0

    var result = Int.MAX_VALUE
    val map = HashMap<Char, Int>()
    val tSize = t.length
    var resultString = ""

    while (r < n) {
        val char = s[r]

        if (char in tSet) {
            map[char] = map.getOrDefault(char, 0) + 1
        }

        if (map.size == tSize) {
            if (r-l+1 < result) {
                result = r - l + 1
                resultString = s.slice(l..r)
            }

            while(map.size != tSize-1) {
                val lChar = s[l]
                if (lChar in tSet) {
                    map[lChar] = map[lChar]!! - 1
                    if (map[lChar] == 0) {
                        map.remove(lChar)
                    }
                }
                l++
            }
            while (l < n && s[l] in map && map[s[l]]!! > 1) {
                map[s[l]] = map[s[l]]!! - 1
                l++
            }

            while (l < n && s[l] !in map) {
                l++
            }
        }

        if (map.isEmpty()) {
            l++
        }

        r++
    }

    return resultString
}

fun main() {
    val input = listOf(
        Pair("ddaaabbca","abc"),
        Pair("a","a"),
        Pair("ADOBECODEBANC","ABC"),
        Pair("aAbBDdcC","Bc"),
    )

    input.forEach {
        println(minWindow(it.first, it. second))
    }
}