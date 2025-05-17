package pattern

import interfaces.Solvable

/**
 * Given an integer n. You need to recreate the pattern given below for any value of N. Let's say for N = 5, the pattern should look like as below:
 *
 * A
 * AB
 * ABC
 * ABCD
 * ABCDE
 *
 */

class Pattern14:Solvable {
    override fun solve(n: Int) {
        repeat(n) {
            val start = 'A'.code
            (start..start+it).forEach { i ->
                print(i.toChar())
            }
            println()
        }
    }
}

fun main() = Pattern14().solve(5)
