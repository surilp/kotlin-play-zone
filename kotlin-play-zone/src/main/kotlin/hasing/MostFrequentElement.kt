package `kotlin-play-zone`.src.main.kotlin.hasing

fun mostFrequentElement(nums: IntArray): Int {
    val hashMap = HashMap<Int, Int>()
    var result = Pair(nums[0], 1)
    for (num in nums) {
        hashMap[num] = hashMap.getOrDefault(num, 0) + 1
        if (result.second < hashMap[num]!!) {
            result = Pair(num, hashMap[num]!!)
        }
    }

    return result.first
}

fun main() {
    val input = intArrayOf(1,2,2,3,3,3)
    println("For input ${input.contentToString()}, result is ${mostFrequentElement(input)}")

    val input1 = intArrayOf(4,4,5,5,6)
    println("For input ${input1.contentToString()}, result is ${mostFrequentElement(input1)}")
}
