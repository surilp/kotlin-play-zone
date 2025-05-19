package pattern

import interfaces.Solvable

/**
 * Given an integer n. You need to recreate the pattern given below for any value of N. Let's say for N = 5, the pattern should look like as below:
 *
 *
 *
 *     A
 *    ABA
 *   ABCBA
 *  ABCDCBA
 * ABCDEDCBA
 */

class Pattern17:Solvable {
    override fun solve(n: Int) {
        val start = 'A'.code
        (1..n).forEach { i ->
            print(" ".repeat(n-i))
            (start..start + (i-1)).forEach { print(it.toChar()) }
            (start + (i-2)downTo start).forEach { print(it.toChar()) }
            print(" ".repeat(n-i))

            println()
        }
    }
}

fun main() = Pattern17().solve(5)
