package `kotlin-play-zone`.src.main.kotlin.hasing

fun secondMostFrequentElement(nums: IntArray): Int {
    val map = HashMap<Int, Int>()
    for (num in nums) {
        map[num] = map.getOrDefault(num, 0) + 1
    }

    var mostFrequent = Pair(-1, -1)
    var secondMostFrequent = Pair(-1, -1)
    for ((key, value) in map) {
        if (value > mostFrequent.second) {
            secondMostFrequent = mostFrequent
            mostFrequent = Pair(key, value)
        } else if (value == mostFrequent.second) {
            mostFrequent = Pair(minOf(key,mostFrequent.first), mostFrequent.second)
        } else if (value > secondMostFrequent.second) {
            secondMostFrequent = Pair(key, value)
        } else if (value == secondMostFrequent.second) {
            secondMostFrequent = Pair(minOf(key, secondMostFrequent.first), secondMostFrequent.second)
        }
    }
    return secondMostFrequent.first
}

fun main() {
    val input = intArrayOf(1, 2, 2, 3, 3, 3)
    println("for input ${input.contentToString()} result is ${secondMostFrequentElement(input)}")

    val input2 = intArrayOf(4, 4, 5, 5, 6, 7)
    println("for input ${input2.contentToString()} result is ${secondMostFrequentElement(input2)}")

    val input3 = intArrayOf(10, 9, 7, 7)
    println("for input ${input3.contentToString()} result is ${secondMostFrequentElement(input3)}")
}
