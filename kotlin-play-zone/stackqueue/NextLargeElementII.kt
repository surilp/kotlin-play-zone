package `kotlin-play-zone`.stackqueue

fun nextLargeElementII(arr: IntArray): IntArray {
    val n = arr.size
    var i = n + n - 1
    val stack = ArrayDeque<Int>()
    val result = IntArray(n)
    while (i >= 0) {
        val updatedI = i % n
        val value = arr[updatedI]

        while (stack.isNotEmpty() && stack.last() <= value) {
            stack.removeLast()
        }
        if (i <= n-1) {
            if (stack.isEmpty()) {
                result[i] = -1
            } else {
                result[i] = stack.last()
            }
        }

        stack.addLast(value)


        i--
    }
    return result
}

fun main() {
    val input = listOf(
        intArrayOf(3, 10, 4, 2, 1, 2, 6, 1, 7, 2, 9),
        intArrayOf(5, 7, 1, 7, 6, 0),
        intArrayOf(1, 2, 3, 4, 5),
    )

    input.forEach {
        println(nextLargeElementII(it).contentToString())
    }
}
