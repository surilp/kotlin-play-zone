package `kotlin-play-zone`.stackqueue

fun removeKDigits(nums: String, k: Int): String {
    val stack = ArrayDeque<Int>()

    var temp = 0
    for (char in nums) {
        val value = char.digitToInt()

        while (stack.isNotEmpty() && stack.last() >= value && temp < k) {
            stack.removeLast()
            temp++
        }

        if (stack.isEmpty() && value == 0) {
            continue
        }

        stack.addLast(value)
    }


    val result = stack.joinToString("")
    return result.ifEmpty { "0" }
}

fun main() {
    val input = listOf(
        Pair("541892", 2),
        Pair("1002991", 3),
        Pair("10", 2),
        Pair("1432219", 3),
        Pair("131000", 3),
    )

    input.forEach {
        println(removeKDigits(it.first, it.second))
    }
}
