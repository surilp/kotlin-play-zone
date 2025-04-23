package basic

class SumOfFirstAndLast {
    fun sumOfFirstAndLast(nums: List<Int>): Int {
        return nums.first() + nums.last()
    }
}

fun main() {
    val sumOfFirstAndLast = SumOfFirstAndLast()

    val nums1 = listOf(2, 3, 4, 5, 6)
    println(sumOfFirstAndLast.sumOfFirstAndLast(nums1))

    val nums2 = listOf(2)
    println(sumOfFirstAndLast.sumOfFirstAndLast(nums2))

    val nums3 = listOf(-1, 2, 4, 1)
    println(sumOfFirstAndLast.sumOfFirstAndLast(nums3))
}