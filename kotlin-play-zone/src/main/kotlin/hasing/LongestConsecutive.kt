package `kotlin-play-zone`.src.main.kotlin.hasing

import `kotlin-play-zone`.src.main.kotlin.array.secondLargestElement
import java.util.TreeMap

fun longestConsecutive(nums: IntArray): Int {
    fun brute(nums: IntArray): Int {
        val sortedNums = nums.sorted()

        var result = 1
        var temp = 1
        var previous = sortedNums[0]

        for (num in sortedNums) {
            if (num - previous == 1) {
                previous = num
                temp++
            } else if (num == previous) {
                // do nothing
            } else {
                previous = num
                result = maxOf(temp, result)
                temp = 0
            }
        }

        return maxOf(result, temp)
    }

    fun best(nums: IntArray): Int {
        val set = HashSet<Int>()

        for(num in nums) {
            set.add(num)
        }

        var temp = 0
        var result = 0

        for (num in set) {
            if (num-1 in set) {
                continue
            }

            var value = num
            while(value in set) {
                temp++
                value++
            }

            result = maxOf(result, temp)
            temp = 0
        }

        return result
    }

    return best(nums)
}

fun main() {
    val input = listOf(
        intArrayOf(100, 4, 200, 1, 3, 2),
        intArrayOf(0, 3, 7, 2, 5, 8, 4, 6, 0, 1),
        intArrayOf(1, 9, 3, 10, 4, 20, 2),
    )

    input.forEach {
        println("For input ${it.contentToString()} result is ${longestConsecutive(it)}")
    }
}
