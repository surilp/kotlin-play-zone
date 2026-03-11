package `kotlin-play-zone`.src.main.kotlin.array

fun removeDuplicates(nums: IntArray): Int {
    val n = nums.size
    var previous: Int? = null
    var j = 0

    for (i in 0 until n) {
        val num = nums[i]
        if (previous != num) {
            nums[j] = num
            previous = num
            j++
        }
    }
    return j
}

fun removeDuplicates2(nums: IntArray): Int {
    val set = LinkedHashSet<Int>()

    for (num in nums) {
        set.add(num)
    }

    var i = 0
    for (item in set) {
        nums[i++] = item
    }

    return set.size
}

fun main() {
    val input = listOf(
        intArrayOf(0, 0, 3, 3, 5, 6),
        intArrayOf(1, 1, 2, 2, 2, 3, 3),
        intArrayOf(-2, 2, 4, 4, 4, 4, 5, 5),
        intArrayOf(-30, -30, 0, 0, 10, 20, 30, 30),
    )

    input.forEach {
        println("For input ${it.contentToString()} result is ${removeDuplicates2(it)}")
        println(", resul array ${it.contentToString()} ")
    }
}
