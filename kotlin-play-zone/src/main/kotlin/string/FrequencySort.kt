package `kotlin-play-zone`.src.main.kotlin.string

import java.util.*

fun frequencySort(s: String): CharArray {
    val orderedHashMap = TreeMap<Char, Int>()

    for (char in s) {
        orderedHashMap[char] = orderedHashMap.getOrDefault(char, 0) + 1
    }

    return orderedHashMap.keys.toCharArray()
}

fun main() {
    val input = listOf(
        "tree",
        "raaaaj",
        "bbccddaaa"
    )

    input.forEach {
        println("For input $it result is ${frequencySort(it).contentToString()}")
    }
}
