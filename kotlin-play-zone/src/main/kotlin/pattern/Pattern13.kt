package pattern

import interfaces.Solvable

/**
 *
 * Given an integer n. You need to recreate the pattern given below for any value of N. Let's say for N = 5, the pattern should look like as below:
 *
 *
 *
 * 1
 * 2 3
 * 4 5 6
 * 7 8 9 10
 * 11 12 13 14 15
 *
 */

class Pattern13:Solvable {
    override fun solve(n: Int) {
        var value = 1
        repeat(5) { i ->
            (1..(i + 1)).forEach { _ ->
                print("$value ")
                value += 1
            }
            println()
        }
    }
}

fun main() = Pattern13().solve(5)
