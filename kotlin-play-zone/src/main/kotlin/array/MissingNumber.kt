package `kotlin-play-zone`.src.main.kotlin.array

fun missingNumber(nums: IntArray): Int {
    val n = nums.size
    val tempArray = IntArray(n + 1)

    for (num in nums) {
        tempArray[num] += 1
    }

    tempArray.forEachIndexed { index, i ->
        if (i == 0) {
            return index
        }
    }

    return -1
}

fun missingNumber2(nums: IntArray): Int {
    val n = nums.size

    val sum = (n * (n+1)) / 2

    return sum - nums.sum()
}


fun main() {
    val input = listOf(
        intArrayOf(0, 2, 3, 1, 4),
        intArrayOf(0, 1, 2, 4, 5, 6),
        intArrayOf(1, 3, 6, 4, 2, 5),
    )

    input.forEach {
        println("For input ${it.contentToString()} result is ${missingNumber2(it)}")
        println(", resul array ${it.contentToString()} ")
    }
}