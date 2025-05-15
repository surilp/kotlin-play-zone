package pattern

/**
 * Given an integer n. You need to recreate the pattern given below for any value of N.
 * Let's say for N = 5, the pattern should look like as below:
 *
 * 1
 * 12
 * 123
 * 1234
 * 12345
 */

class Pattern3 {
    fun pattern3(n:Int) {
        repeat(n) { i ->
            println((1..i+1).joinToString(""))
        }
    }
}

fun main() {
    val pattern3 = Pattern3()
    pattern3.pattern3(9)
}