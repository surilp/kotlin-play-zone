package `kotlin-play-zone`.src.main.kotlin.array

fun findMaxConsecutiveOnes(nums: IntArray): Int {
    var result = 0
    var temp = 0

    for (num in nums) {
        if (num == 1) {
            temp++
        } else {
            result = temp
            temp = 0
        }
    }

    return maxOf(result,temp)
}

fun main() {
    val input = listOf(
        intArrayOf(1, 1, 0, 0, 1, 1, 1, 0),
        intArrayOf(0, 0, 0, 0, 0, 0, 0, 0),
        intArrayOf(1, 0, 1, 1, 1, 0, 1, 1, 1),
    )

    input.forEach {
        println("For input ${it.contentToString()} result is ${findMaxConsecutiveOnes(it)}")
    }
}
