package `kotlin-play-zone`.src.main.kotlin.binarysearch


fun nThRoot(n: Int, m: Int): Int {
    var start = 1
    var end = m

    while (start <= end) {
        val mid = (start + end) / 2

        val temp = pow(mid, n)
        if (temp == m) {
            return mid
        } else if (temp > m) {
            end = mid - 1
        } else {
            start = mid + 1
        }
    }

    return -1
}


fun pow(num: Int, exp: Int): Int {
    var result = 1

    if (exp == 0) {
        return result
    }

    for (value in 1..exp) {
        result *= num
    }
    return result
}

fun main() {
    val input = listOf(
        Pair(3, 27),
        Pair(4, 69),
        Pair(4, 81),

    )

    input.forEach {
        println("For input ${it}, result is ${nThRoot(it.first, it.second)}")
    }
}
