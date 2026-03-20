package `kotlin-play-zone`.src.main.kotlin.twopointers

import java.util.TreeMap

fun characterReplacement(s: String, k: Int): Int {
    val map = TreeMap<Char, Int>()

    var r = 0
    var l = 0
    val n = s.length

    var result = 0

    while (r < n) {
        val char = s[r]
        map[char] = map.getOrDefault(char, 0) + 1

        if (!eligible(map, k)) {
            val lChar = s[l]
            map[lChar] = map[lChar]!! - 1
            if (map[lChar] == 0) {
                map.remove(lChar)
            }
            l++
        }

        if (eligible(map,k)) {
            result = maxOf(result, r - l + 1)
        }

        r++
    }

    return result
}

fun eligible(map: TreeMap<Char, Int>, k:Int): Boolean {
    if (map.size <= 1) {
        return true
    } else {
        val values = map.values.toList()
        val sum = values.slice(1 until values.size).sum()
        return sum <= k
    }
}

fun main() {
    val input = listOf(
        Pair("BAABAABBBAAA", 2),
        Pair("AABABBA", 1),
        Pair("ABCDEF", 1),
    )

    input.forEach {
        println(characterReplacement(it.first, it.second))
    }
}