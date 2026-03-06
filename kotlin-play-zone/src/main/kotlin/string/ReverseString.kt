package `kotlin-play-zone`.src.main.kotlin.string

fun reverseString(s: CharArray) {
    val size = s.size
    var start = 0
    var end = size - 1

    while(start < end) {
        s[start] = s[end]. also { s[end] = s[start] }
        start++
        end--
    }
}

fun main() {
    val input = listOf(
        charArrayOf('h','e','l','l','o'),
        charArrayOf('b','y','e'),
        charArrayOf('h','a','n','n','a','h')
    )

    input.forEach {
        print("For input ${it.contentToString()}, ")
        reverseString(it)
        print("result is ${it.contentToString()}")
        println()
    }
}
