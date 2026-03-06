package `kotlin-play-zone`.src.main.kotlin.string

fun isomorphicString(s: String, t: String): Boolean {
    val sSize = s.length
    val tSize = t.length

    if (sSize != tSize) {
        return false
    }

    var sCounter = 0

    val mapS = HashMap<Char, Char>()
    val mapT = HashMap<Char, Char>()
    while (sCounter < sSize) {
        if (mapS[s[sCounter]] == null && mapT[t[sCounter]] == null) {
            mapS[s[sCounter]] = t[sCounter]
            mapT[t[sCounter]] = s[sCounter]
        } else {
            if (mapS[s[sCounter]] != t[sCounter] && mapT[t[sCounter]] != s[sCounter]){
                return false
            }
        }
//        println(mapS)
//        println(mapT)
        sCounter++
    }

    return true
}

fun main() {
    val input = listOf(
        Pair("egg", "add"),
        Pair("apple", "bbnbm"),
        Pair("paper", "title"),
        Pair("ab", "cc")
    )

    input.forEachIndexed { i, item ->
        println("For input ${input[i]} result is ${isomorphicString(item.first, item.second)}")
    }
}