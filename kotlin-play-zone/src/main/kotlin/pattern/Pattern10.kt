package pattern

import interfaces.Solvable

/**
 * Given an integer n. You need to recreate the pattern given below for any value of N. Let's say for N = 5, the pattern should look like as below:
 *
 * *
 * **
 * ***
 * ****
 * *****
 * ****
 * ***
 * **
 * *
 */

class Pattern10:Solvable {
    override fun solve(n: Int) {
        Pattern2().pattern2(n)
        Pattern5().solve(n-1)
    }
}

fun main() = Pattern10().solve(5)

