package `kotlin-play-zone`.src.main.kotlin.binarysearch

fun roseGarden(n: Int, nums: IntArray, k: Int, m:Int): Int {
    if (k * m > n) {
        return - 1
    }

    var start = nums.min()
    var end = nums.max()

    var result = -1
    while (start <= end) {
        val mid = (start + end) / 2

        val numOfBouquets = numOfBouquets(nums, mid, k)

        if (numOfBouquets >= m) {
            result = mid
            end = mid - 1
        } else {
            start = mid + 1
        }
    }

    return result
}

fun numOfBouquets(nums: IntArray, day: Int, k:Int): Int {
    var result = 0
    var temp = 0

    for (num in nums) {
        if (day >= num) {
            temp++
        } else {
            result += temp / k
            temp = 0
        }
    }

    result += temp / k

    return result
}

fun main() {
    var nums = intArrayOf(7, 7, 7, 7, 13, 11, 12, 7)
    var k = 3

    println(
        roseGarden(
            nums.size,
            nums,
            k,
            2
        )
    )


    nums = intArrayOf(1, 10, 3, 10, 2)
    k = 2

    println(
        roseGarden(
            nums.size,
            nums,
            k,
            3
        )
    )

    nums = intArrayOf(1, 10, 3, 10, 2)
    k = 1

    println(
        roseGarden(
            nums.size,
            nums,
            k,
            3
        )
    )
}
