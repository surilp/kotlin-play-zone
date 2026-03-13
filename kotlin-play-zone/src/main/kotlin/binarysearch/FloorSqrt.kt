package `kotlin-play-zone`.src.main.kotlin.binarysearch

fun floorSqrt(n: Int): Int {
    var start = 1
    var end = n

    var result = 0

    while (start <= end ) {
        val mid = (start + end) / 2

        if(mid * mid > n) {
            end = mid - 1
        } else {
            start = mid + 1
            result = mid
        }

    }
    return result
}

fun main() {
    val input = listOf(
        36, 28, 50, 1
    )

    input.forEach {
        println("For input $it, result is ${floorSqrt(it)}")
    }
}
