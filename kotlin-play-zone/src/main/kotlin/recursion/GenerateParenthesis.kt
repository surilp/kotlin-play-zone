package `kotlin-play-zone`.src.main.kotlin.recursion

fun generateParenthesis(n: Int): List<String> {
    val ds = mutableListOf<Char>()
    val result = mutableListOf<String>()

    fun helper(open: Int, close: Int, n:Int, ds: MutableList<Char>, result: MutableList<String>) {

        if (open + close == 2 * n) {
            result.add(ds.joinToString(""))
            return
        }
        if (open < n) {
            ds.add('(')
            helper(open + 1, close, n , ds, result)
            ds.removeLast()
        }

        if (close < open) {
            ds.add(')')
            helper(open, close + 1, n , ds, result)
            ds.removeLast()
        }

    }

    helper(0, 0, n, ds, result)

    return result.toList()
}


fun main() {
    println(generateParenthesis(2))
}