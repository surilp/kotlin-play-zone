package `kotlin-play-zone`.src.main.kotlin.recursion

fun isPalindrome(s: String): Boolean {
    val len = s.length
    val start = 0
    val end = len - 1

    fun helper(s: String, start: Int, end: Int): Boolean {
        if (start >= end) {
            return true
        }

        if (s[start] != s[end]) {
            return false
        }

        return helper(s, start + 1, end - 1)
    }

    return helper(s, 0, end)
}

fun main() {
    val input = listOf(
        "hannah",
        "aabbaA",
        "aabbcccdbbaa",
    )

    input.forEach {
        println("For input $it, result is ${isPalindrome(it)}")
    }
}
