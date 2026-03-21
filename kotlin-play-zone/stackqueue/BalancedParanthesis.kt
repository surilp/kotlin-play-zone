package `kotlin-play-zone`.stackqueue

fun balancedParanthesis(str: String): Boolean {
    val map = hashMapOf(
        '}' to '{',
        ')' to '(',
        ']' to '['
    )

    val open = map.values.toSet()
    val stack = ArrayDeque<Char>()
    for (char in str) {
        if (char in open) {
            stack.addLast(char)
        } else {
            if (stack.isNotEmpty() && stack.last() == map[char]) {
                stack.removeLast()
            } else {
                return false
            }
        }
    }

    return stack.isEmpty()
}

fun main() {
    val input = listOf(
        "()[{}()]",
        "[()",
        "{[()]}"
    )

    input.forEach {
        println(balancedParanthesis(it))
    }
}