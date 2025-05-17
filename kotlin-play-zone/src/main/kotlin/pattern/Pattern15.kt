package pattern

import interfaces.Solvable

/**
 *
 * Given an integer n. You need to recreate the pattern given below for any value of N. Let's say for N = 5, the pattern should look like as below:
 *
 *
 * ABCDE
 * ABCD
 * ABC
 * AB
 * A
 *
 *
 */

class Pattern15:Solvable {
    override fun solve(n: Int) {
        val start = 'A'.code
        (n downTo 1).forEach {i ->
            (start until i+start).forEach { print(it.toChar()) }
            println()
        }
    }
}

fun main() = Pattern15().solve(5)
