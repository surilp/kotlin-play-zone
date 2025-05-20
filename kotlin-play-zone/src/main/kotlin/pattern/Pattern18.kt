package pattern

import interfaces.Solvable

/**
 * Given an integer n. You need to recreate the pattern given below for any value of N. Let's say for N = 5, the pattern should look like as below:
 *
 *
 *
 * E
 * D E
 * C D E
 * B C D E
 * A B C D E
 */

class Pattern18:Solvable {
    override fun solve(n: Int) {
        val start = 'A'.code
        (n downTo 1).forEach { i ->
            (i..n).forEach { print((it+start-1).toChar() + " ") }
            println()
        }
    }
}

fun main() = Pattern18().solve(5)