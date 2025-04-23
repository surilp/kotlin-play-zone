package basic

class Solution {
    fun printX(x: Int, n: Int) {
        (0 until  n).forEach {
            print("$x ")
        }
        println()
    }

    fun printXV2(x: Int, n: Int) {
        repeat(n) {
            print("$x ")
        }
        println()
    }
}

fun main() {
    val solution = Solution()

    solution.printX(7, 5)
    solution.printXV2(7,5)
}