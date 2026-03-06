package `kotlin-play-zone`.src.main.kotlin.hasing

fun sumHighestAndLowestFrequency(nums: IntArray): Int {
    val map = HashMap<Int, Int>()

    for (num in nums) {
        map[num] = map.getOrDefault(num, 0) + 1
    }

    var lowestFrequency = Int.MAX_VALUE
    var highestFrequency = -1

    for ((_, value) in map) {
        if (value > highestFrequency) {
            highestFrequency = value
        }
        if (value < lowestFrequency) {
            lowestFrequency = value
        }
    }

    return lowestFrequency + highestFrequency
}

fun main() {
    val input = listOf(
        intArrayOf(1,2,2,3,3,3),
        intArrayOf(4,4,5,5,6),
        intArrayOf(10,9,7,7,8,8,8)
    )

    input.forEach {
        println("For input ${it.contentToString()}, the result is ${sumHighestAndLowestFrequency(it)}")
    }
}
