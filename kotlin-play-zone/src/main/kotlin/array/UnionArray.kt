package `kotlin-play-zone`.src.main.kotlin.array

fun unionArray(nums1: IntArray, nums2: IntArray): IntArray {
    val n1 = nums1.size
    val n2 = nums2.size
    val result = mutableListOf<Int>()

    var i = 0
    var j = 0

    while (i < n1 && j < n2) {
        val num1 = nums1[i]
        val num2 = nums2[j]

        if (num1 < num2) {
            if (result.isEmpty() || result.last() != num1) {
                result.add(num1)
            }
            i++
        } else if (num1 == num2) {
            if (result.isEmpty() || result.last() != num1) {
                result.add(num1)
            }
            i++
            j++
        } else {
            if (result.isEmpty() || result.last() != num2) {
                result.add(num2)
            }
            j++
        }
    }

    while (i < n1) {
        if (result.isEmpty() || result.last() != nums1[i]) {
            result.add(nums1[i])
        }
        i++
    }

    while (j < n2) {
        if (result.isEmpty() || result.last() != nums2[j]) {
            result.add(nums2[j])
        }
        j++
    }

    return result.toIntArray()
}

fun main() {
    val input = listOf(
        Pair(intArrayOf(1, 2, 3, 4, 5), intArrayOf(1, 2, 7)),
        Pair(intArrayOf(3, 4, 6, 7, 9, 9), intArrayOf(1, 5, 7, 8, 8)),
        Pair(intArrayOf(3, 4, 4, 4), intArrayOf(6, 7, 7))
    )

    input.forEach {
        println(
            "For input ${it.first.contentToString()}, ${it.second.contentToString()}, result is ${
                unionArray(
                    it.first,
                    it.second
                ).contentToString()
            }"
        )
    }
}
