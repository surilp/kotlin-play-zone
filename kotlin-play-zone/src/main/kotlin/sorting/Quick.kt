package `kotlin-play-zone`.src.main.kotlin.sorting

fun quickSort(nums: IntArray): IntArray {
    fun partitionLogic(nums: IntArray, start: Int, end: Int): Int {

        val pivot = nums[start]
        val pivotIndex = start

        var i = start
        var j = end

        while(i <= j) {
            while (i <= end && nums[i] <= pivot) {
                i++
            }
            while (j >= start && nums[j] > pivot ) {
                j--
            }

            if (i > end || j < start || i > j) {
                break
            }

            nums[i] = nums[j].also { nums[j] = nums[i] }
            i++
            j--
        }

        if (j < start) {
            return pivotIndex
        }
        nums[pivotIndex] = nums[j].also { nums[j] = nums[pivotIndex] }
        return j
    }


    fun helper(nums: IntArray, start: Int, end: Int) {
        if (start >= end) {
            return
        }
        val pivotIndex = partitionLogic(nums, start, end)
        helper(nums, start, pivotIndex - 1)
        helper(nums, pivotIndex + 1, end)
    }

    helper(nums, 0, nums.size - 1)

    return nums
}

fun main() {
    val input = listOf(
        intArrayOf(7, 4, 1, 5, 3, 7),
        intArrayOf(5, 4, 4, 1, 1),
        intArrayOf(3, 2, 3, 4, 5),
    )

    input.forEach {
        println("For input ${it.contentToString()}, result is ${quickSort(it).contentToString()}")
    }
}