package pattern

import interfaces.Solvable

/**
 * Given an integer n. You need to recreate the pattern given below for any value of N. Let's say for N = 5, the pattern should look like as below:
 *
 *
 *
 * *********
 *  *******
 *   *****
 *    ***
 *     *
 *
 */

class Pattern8:Solvable {
    override fun solve(n: Int) {
        repeat(5) {
            print(" ".repeat(it))
            val i = 2*(n - it) - 1
            print("*".repeat(i))
            print(" ".repeat(it))
            println()
        }
    }
}

fun main() = Pattern8().solve(5)