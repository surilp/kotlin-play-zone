package pattern

import interfaces.Solvable

/**
 *
 * Given an integer n. You need to recreate the pattern given below for any value of N. Let's say for N = 5, the pattern should look like as below:
 *
 * 1
 * 0 1
 * 1 0 1
 * 0 1 0 1
 * 1 0 1 0 1
 *
 */

class Pattern11:Solvable {
    override fun solve(n: Int) {
        (1..n).forEach { i ->
            val isEven =
                i % 2 == 0
            (1..i).forEach { j ->
                if (isEven) {
                    print(if (j % 2 == 0) 1 else 0)
                } else {
                    print(if (j % 2 == 0) 0 else 1)
                }
            }
            println()
        }
    }
}

fun main() = Pattern11().solve(5)