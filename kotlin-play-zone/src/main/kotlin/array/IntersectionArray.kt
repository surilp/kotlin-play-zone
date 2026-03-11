package `kotlin-play-zone`.src.main.kotlin.array

fun intersectionArray(nums1: IntArray, nums2: IntArray): IntArray {
    val n1 = nums1.size
    val n2 = nums2.size
    val result = mutableListOf<Int>()

    var i = 0
    var j = 0

    while (i < n1 && j < n2) {
        val num1 = nums1[i]
        val num2 = nums2[j]

        if (num1 == num2) {
            result.add(num1)
            i++
            j++
        } else if (num1 > num2) {
            j++
        } else {
            i++
        }
    }

    return result.toIntArray()
}

fun main() {
    val input = listOf(
        Pair(intArrayOf(1, 2, 2, 3, 5), intArrayOf(1, 2, 7)),
        Pair(intArrayOf(1, 2, 2, 3, 3, 3), intArrayOf(2, 3, 3, 4, 5, 7)),
        Pair(intArrayOf(-45, -45, 0, 0, 2), intArrayOf(-50, -45, 0, 0, 5, 7))
    )

    input.forEach {
        println(
            "For input ${it.first.contentToString()}, ${it.second.contentToString()}, result is ${
                intersectionArray(
                    it.first,
                    it.second
                ).contentToString()
            }"
        )
    }
}
