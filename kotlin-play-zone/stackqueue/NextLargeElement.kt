package `kotlin-play-zone`.stackqueue

fun nextLargeElement(arr: IntArray): IntArray {
    val stack = ArrayDeque<Int>()
    val result = IntArray(arr.size)
    var i = arr.size - 1

    while (i >= 0) {
        while (stack.isNotEmpty() && stack.last() < arr[i]) {
            stack.removeLast()
        }

        if (stack.isEmpty()) {
            result[i] = -1
        } else {
            result[i] = stack.last()
        }

        stack.addLast(arr[i])

        i--
    }

    return result
}

fun main() {
    val input = listOf(
        intArrayOf(1, 3, 2, 4),
        intArrayOf(6, 8, 0, 1, 3),
        intArrayOf(1, 3, 2),
    )

    input.forEach {
        println(nextLargeElement(it).contentToString())
    }
}