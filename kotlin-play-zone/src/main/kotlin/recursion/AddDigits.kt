package `kotlin-play-zone`.src.main.kotlin.recursion

fun addDigits(num: Int): Int {

    fun sumDigits(num: Int): Int {
        if (num == 0) {
            return 0
        }

        return (num % 10) + addDigits(num / 10)
    }

    val sumD = sumDigits(num)
    if (sumD / 10 == 0) {
        return sumD
    }

    return addDigits(sumD)
}

fun main() {
    val input = listOf(
        529,
        101,
        38
    )

    input.forEach {
        println("For input $it, result is ${addDigits(it)}")
    }
}
