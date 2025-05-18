package pattern

import interfaces.Solvable

class Pattern16:Solvable {
    override fun solve(n: Int) {
        var start = 'A'.code
        repeat(n) {
            println(start.toChar().toString().repeat(it + 1))
            start += 1
        }
    }
}

fun main() = Pattern16().solve(5)
