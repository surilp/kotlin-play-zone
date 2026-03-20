package `kotlin-play-zone`.src.main.kotlin.twopointers

import kotlin.math.max

fun maxScore(cardScore: IntArray, k: Int): Int {
    if (cardScore.size < k) {
        return -1
    }

    var l = 0
    var r = k - 1

    var sum = 0
    var maxSum: Int

    var i = 0
    while (i <= r) {
        sum += cardScore[i]
        i++
    }
    maxSum = sum

    while (r <  cardScore.size - 1) {
        sum -= cardScore[l]
        l++

        r++
        sum += cardScore[r]

        maxSum = maxOf(sum, maxSum)
    }

    return maxSum
}

fun maxScoreII(cardScore: IntArray, k: Int): Int {
    val n = cardScore.size
    if (n < k) {
        return -1
    }

    var sum = 0
    var maxSum = 0

    var l = 0
    var r = k - 1

    var i = 0
    while (i <= r) {
        sum += cardScore[i]
        i++
    }

    maxSum = sum
//    println("sum $sum")
    r = n
    l = k - 1
    while (l >= 0) {
//        println(cardScore[l])
        sum -= cardScore[l]
        l--

        r--
//        println(cardScore[r])
        sum += cardScore[r]
//        println("sum $sum")
        maxSum = maxOf(sum, maxSum)
    }

    return maxSum
}

fun main() {
    val input = listOf(
        Pair(intArrayOf(1, 2, 3, 4, 5, 6), 3),
        Pair(intArrayOf(5, 4, 1, 8, 7, 1, 3 ), 3),
        Pair(intArrayOf(9, 10, 1, 2, 3, 5), 5),
    )

    input.forEach {
        println(maxScoreII(it.first, it.second))
    }
}