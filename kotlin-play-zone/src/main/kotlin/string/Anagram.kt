package `kotlin-play-zone`.src.main.kotlin.string

fun isAnagram(s: String, t: String): Boolean {
    val hashMapS = HashMap<Char, Int>()
    for (item in s) {
        hashMapS[item] = hashMapS.getOrDefault(item, 0) + 1
    }

    val hashMapT = HashMap<Char, Int>()
    for (item in t) {
        hashMapT[item] = hashMapT.getOrDefault(item, 0) + 1
    }

    for ((key, value) in hashMapS) {
        if (hashMapT[key] != value) {
            return false
        }
    }

    return true
}

fun main() {
    val input = listOf(
        Pair("anagram", "nagaram"),
        Pair("dog", "cat"),
        Pair("eat", "tea"),
    )

    input.forEach{
        println("For input $it, result is ${isAnagram(it.first, it.second)}")
    }
}
