package pattern

import interfaces.Solvable

/**
 * Given an integer n. You need to recreate the pattern given below for any value of N. Let's say for N = 5, the pattern should look like as below:
 *
 *
 *
 *     *
 *    ***
 *   *****
 *  *******
 * *********
 * *********
 *  *******
 *   *****
 *    ***
 *     *
 */

class Pattern9:Solvable {
    override fun solve(n: Int) {
        Pattern7().solve(n)
        Pattern8().solve(n)
    }
}

fun main() = Pattern9().solve(5)
