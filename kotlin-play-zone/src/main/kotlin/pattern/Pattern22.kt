package pattern

import interfaces.Solvable

/**
 * Given an integer n. You need to recreate the pattern given below for any value of N. Let's say for N = 5, the pattern should look like as below:
 *
 *
 *
 * 5 5 5 5 5 5 5 5 5
 * 5 4 4 4 4 4 4 4 5
 * 5 4 3 3 3 3 3 4 5
 * 5 4 3 2 2 2 3 4 5
 * 5 4 3 2 1 2 3 4 5
 * 5 4 3 2 2 2 3 4 5
 * 5 4 3 3 3 3 3 4 5
 * 5 4 4 4 4 4 4 4 5
 * 5 5 5 5 5 5 5 5 5
 */

class Pattern22:Solvable {
    override fun solve(n: Int) {
        (n downTo  1).forEach { i ->
            (n downTo i).forEach { print("$it ") }
            if (i > 1) {
                print("$i ".repeat(1 + 2*(i-2)))
                (i .. n).forEach { print("$it ") }
            } else {
                (i+1 .. n).forEach { print("$it ") }
            }
            println()
        }

        (2 ..  n).forEach { i ->
            (n downTo i).forEach { print("$it ") }
            print("$i ".repeat(1 + 2*(i-2)))
            (i..n).forEach { print("$it ") }
            println()
        }
    }
}

fun main() = Pattern22().solve(5)
