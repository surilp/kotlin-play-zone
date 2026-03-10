package `kotlin-play-zone`.src.main.kotlin.sorting

fun mergeSort(nums: IntArray): IntArray {
    fun swap(nums: IntArray, indexI: Int, indexJ: Int) {
        nums[indexI] = nums[indexJ].also { nums[indexJ] = nums[indexI] }
    }

    fun merge(left: IntArray, right: IntArray): IntArray {
        val leftN = left.size
        val rightN = right.size
        val n = leftN + rightN
        val result = IntArray(n)
        var i = 0
        var j = 0
        var resultI = 0

        while (i < leftN && j < rightN) {
            if (left[i] <= right[j]) {
                result[resultI] = left[i]
                i++
            } else {
                result[resultI] = right[j]
                j++
            }
            resultI++
        }
        while (i < leftN) {
            result[resultI] = left[i]
            i++
        }
        while (j < rightN) {
            result[resultI] = right[j]
            j++
        }
        return result
    }

    fun helper(nums: IntArray, start: Int, end: Int): IntArray {
        if (start == end) {
            return intArrayOf(nums[start])
        }

        val mid = (start + end) / 2
        val left = helper(nums, start, mid)
        val right = helper(nums, mid + 1, end)
        return merge(left, right)
    }

    return helper(nums, 0, nums.size - 1)
}

fun main() {
    val input = listOf(
        intArrayOf(7, 4, 1, 5, 3),
        intArrayOf(5, 4, 4, 1, 1),
        intArrayOf(3, 2, 3, 4, 5),
    )

    println(9/2)

    input.forEach {
        println("For input ${it.contentToString()}, result is ${insertionSort(it).contentToString()}")
    }
}
