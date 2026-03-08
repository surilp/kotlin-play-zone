package `kotlin-play-zone`.src.main.kotlin.recursion

fun reverseString(s: CharArray): CharArray {
    val size = s.size
    val result = CharArray(size)

    fun helper(s: CharArray, size: Int, i: Int) {
        if (i >= size) {
            return
        }

        helper(s, size, i + 1)
        result[size - i - 1] = s[i]
    }

    val start = 0
    val end = size - 1
    fun helper2(s: CharArray, start: Int, end: Int) {
        if (start >= end) {
            return
        }
        s[start] = s[end].also { s[end] = s[start] }
        helper2(s, start + 1, end - 1)
    }

//    helper(s, size, 0)
    helper2(s, start, end)

    return s
}

fun main() {
    val input = listOf(
        charArrayOf('h', 'e', 'l', 'l', 'o'),
        charArrayOf('b', 'y', 'e'),
        charArrayOf('h', 'a', 'n', 'n', 'a', 'h')
    )

    input.forEach {
        println("For input ${it.contentToString()}, result is ${reverseString(it).contentToString()}")
    }
}
