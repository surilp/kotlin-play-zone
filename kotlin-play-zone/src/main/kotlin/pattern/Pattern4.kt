package pattern

import interfaces.Solvable

/**
 * Given an integer n. You need to recreate the pattern given below for any value of N. Let's say for N = 5, the pattern should look like as below:
 *
 * 1
 * 22
 * 333
 * 4444
 * 55555
 *
 */

class Pattern4: Solvable {
    override fun solve(n:Int) {
        repeat(n) { i ->
            println((i+1).toString().repeat(i+1))
        }
    }
}

fun main() {
    Pattern4().solve(5)
}