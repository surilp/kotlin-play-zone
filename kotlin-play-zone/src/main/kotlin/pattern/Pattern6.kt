package pattern

import interfaces.Solvable

/**
 * Given an integer n. You need to recreate the pattern given below for any value of N. Let's say for N = 5, the pattern should look like as below:
 *
 * 12345
 * 1234
 * 123
 * 12
 * 1
 *
 */

class Pattern6:Solvable {
    override fun solve(n: Int) {
        (5 downTo  1).forEach { i ->
            (1..i).forEach { print(it) }
            println()
        }
    }
}

fun main() = Pattern6().solve(5)