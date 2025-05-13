package pattern

/**
 * Given an integer n. You need to recreate the pattern given below for any value of N. Let's say for N = 5,
 * the pattern should look like as below:
 *
 * *****
 * *****
 * *****
 * *****
 * *****
 *
 *
 */

class Pattern1 {
    fun pattern1(n: Int) {
        repeat(n) {
            repeat(n) {
                print("*")
            }
            println()
        }
    }

    fun pattern1V2(n: Int) {
        val line = "*".repeat(n)
        repeat(n) {
            println(line)
        }
    }
}

fun main() {
    val pattern1 = Pattern1()
    pattern1.pattern1V2(10)
}
