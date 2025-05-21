package pattern

import interfaces.Solvable

class Pattern21:Solvable {
    override fun solve(n: Int) {
        for (i in 0 until n) {
            when (i) {
                0, n - 1 -> println("*".repeat(n))
                else -> println("*" + " ".repeat(n - 2) + "*")
            }
        }
    }
}

fun main() = Pattern21().solve(5)
