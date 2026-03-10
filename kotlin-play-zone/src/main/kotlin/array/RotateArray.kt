package `kotlin-play-zone`.src.main.kotlin.array

fun rotateArray(nums: IntArray, k: Int): IntArray {
    val size = nums.size
    val newK = k % size

    fun approach1(nums: IntArray, k: Int): IntArray {
        val size = nums.size

        val temp = IntArray(k)
        for (i in 0 until k) {
            temp[i] = nums[i]
        }

        for (i in k until size) {
            nums[i - k] = nums[i]
        }

        for (i in (size - k) until size) {
            nums[i] = temp[i - (size - k)]
        }

        return nums
    }

    fun reverse(nums: IntArray, start: Int, end: Int) {
        var iS = start
        var iE = end
        while (iS < iE) {
            nums[iS] = nums[iE].also {nums[iE] = nums[iS]}
            iS++
            iE--
        }
    }

    fun approach2(nums: IntArray, k: Int): IntArray {
        val size = nums.size
        reverse(nums, 0, size -1)
        reverse(nums, 0, size - k - 1)
        reverse(nums, size - k, size - 1)

        return nums
    }

    return approach2(nums, newK)
}

fun main() {
    val input = listOf(
        Pair(intArrayOf(1, 2, 3, 4, 5, 6), 2),
        Pair(intArrayOf(3, 4, 1, 5, 3, -5), 8),
        Pair(intArrayOf(1, 2, 3, 4, 5), 4),
    )

    input.forEach {
        println(
            "For input ${it.first.contentToString()} and ${it.second}, result is ${
                rotateArray(
                    it.first,
                    it.second
                ).contentToString()
            }"
        )
    }
}
