package pattern

import interfaces.Solvable

/**
 * Given an integer n. You need to recreate the pattern given below for any value of N. Let's say for N = 5, the pattern should look like as below:
 *
 *
 *
 * *        *
 * **      **
 * ***    ***
 * ****  ****
 * **********
 * ****  ****
 * ***    ***
 * **      **
 * *        *
 */

class Pattern20:Solvable {
    override fun solve(n: Int) {
        (1..n).forEach { i ->
            print("*".repeat(i))
            print(" ".repeat(2*(n-i)))
            print("*".repeat(i))
            println()
        }
        ((n-1)downTo 1).forEach { i ->
            print("*".repeat(i))
            print(" ".repeat(2+2*(n-i-1)))
            print("*".repeat(i))
            println()
        }
    }
}

fun main() = Pattern20().solve(5)