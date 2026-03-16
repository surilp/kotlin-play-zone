package `kotlin-play-zone`.src.main.kotlin.recursion

fun letterCombinations(digits: String): List<String> {
    val result = mutableListOf<String>()
    val ds = mutableListOf<Char>()
    val n = digits.length

    val map = hashMapOf<Char, CharArray>(
        '1' to charArrayOf('x'),
        '2' to charArrayOf('a', 'b', 'c'),
        '3' to charArrayOf('d', 'e', 'f'),
        '4' to charArrayOf('g', 'h', 'i'),
        '5' to charArrayOf('j', 'k', 'l'),
        '6' to charArrayOf('m', 'n', 'o'),
        '7' to charArrayOf('p', 'q', 'r', 's'),
        '8' to charArrayOf('t', 'u', 'v'),
        '9' to charArrayOf('w', 'x', 'y', 'z'),
    )

    fun helper(current: Int) {
        if (ds.size == n) {
            result.add(ds.joinToString(""))
            return
        }

        for (i in current until n) {
            val num = digits[i]
            val chars = map[num]!!

            for (char in chars) {
                ds.add(char)
                helper(i + 1)
                ds.removeLast()
            }
        }
    }

    helper(0)
    return result
}

fun main() {
    val input = listOf(
        "34",
        "3",
        "8"
    )

    input.forEach { item ->
        println("For input, $item")
        val result = letterCombinations(item)
        println("Result is")
        result.forEach { println(it) }
    }
}
