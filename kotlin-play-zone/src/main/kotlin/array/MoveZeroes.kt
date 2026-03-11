package `kotlin-play-zone`.src.main.kotlin.array

fun moveZeroes(nums: IntArray): IntArray {
    val n = nums.size
    var i = 0
    var j = 0

    while (i < n && j < n) {
        while (i < n && nums[i] == 0) {
            i++
        }

        while (j < n && nums[j] != 0) {
            j++
        }

        if (i < n && j < n){
            nums[i] = nums[j].also{ nums[j] = nums[i] }
        }

        i++
        j++
    }

    return nums
}

fun main() {
    val input = listOf(
        intArrayOf(0, 1, 4, 0, 5, 2),
        intArrayOf(0, 0, 0, 1, 3, -2),
        intArrayOf(0, 20, 0, -20, 0, 20),
    )

    input.forEach {
        println("For input ${it.contentToString()} result is ${moveZeroes(it).contentToString()}")
    }
}
