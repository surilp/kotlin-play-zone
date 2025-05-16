package pattern

import interfaces.Solvable

/**
 *
 * Given an integer n. You need to recreate the pattern given below for any value of N. Let's say for N = 5, the pattern should look like as below:
 *
 *
 *
 * 1        1
 * 12      21
 * 123    321
 * 1234  4321
 * 1234554321
 *
 */

class Pattern12:Solvable {
    override fun solve(n: Int) {
        val size = n * 2
        (1..n).forEach {
            print((1..it).joinToString("" ))
            val i = (size-2) - 2*(it - 1)
            print(" ".repeat(i))
            print((it downTo  1).joinToString(""))
            println()
        }
    }
}

fun main() = Pattern12().solve(5)