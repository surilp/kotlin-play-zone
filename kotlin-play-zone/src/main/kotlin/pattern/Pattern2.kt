package pattern

/**
 *
 * Given an integer n. You need to recreate the pattern given below for any value of N. Let's say for N = 5, the pattern should look like as below:
 *
 * *
 * **
 * ***
 * ****
 * *****
 *
 */

class Pattern2 {
    fun pattern2(n:Int) {
        repeat(n) { i ->
            println("*".repeat(i + 1))
        }
    }
}

fun main() {
    val pattern2 = Pattern2()
    pattern2.pattern2(5)
}