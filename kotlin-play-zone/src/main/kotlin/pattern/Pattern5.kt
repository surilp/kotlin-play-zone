package pattern

import interfaces.Solvable

/**
 * Given an integer n. You need to recreate the pattern given below for any value of N. Let's say for N = 5, the pattern should look like as below:
 *
 * *****
 * ****
 * ***
 * **
 * *
 *
 *
 */

class Pattern5:Solvable {
    override fun solve(n: Int) {
        (5 downTo 1).forEach { i ->
            println("*".repeat(i))
        }
    }
}

fun main() = Pattern5().solve(5)