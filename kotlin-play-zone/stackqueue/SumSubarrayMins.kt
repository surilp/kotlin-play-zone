package `kotlin-play-zone`.stackqueue

fun sumSubarrayMins(arr: IntArray): Int {
    val smallNext = smallNumberNext(arr)
    val smallOrEqualBefore = smallOrEqualToNumberBefore(arr)

    val n = arr.size
    var i = 0
    var result = 0
    while (i < n) {
        val sN = smallNext[i]
        val sB = smallOrEqualBefore[i]

        result += (sN - i) * (i - sB) * arr[i]

        i++
    }

    return result
}

fun smallNumberNext(arr: IntArray): IntArray {
    val n = arr.size
    val stack = ArrayDeque<Int>()
    val result = IntArray(n)

    var i = n - 1
    while (i >= 0) {
        while (stack.isNotEmpty() && arr[stack.last()] >= arr[i]) {
            stack.removeLast()
        }

        if (stack.isEmpty()) {
            result[i] = n
        } else {
            result[i] = stack.last()
        }

        stack.addLast(i)

        i--
    }

    return result
}

fun smallOrEqualToNumberBefore(arr: IntArray): IntArray {
    val n = arr.size
    val stack = ArrayDeque<Int>()
    val result = IntArray(n)

    var i = 0

    while (i < n) {
        while (stack.isNotEmpty() && arr[stack.last()] > arr[i]) {
            stack.removeLast()
        }

        if (stack.isEmpty()) {
            result[i] = -1
        } else {
            result[i] = stack.last()
        }

        stack.addLast(i)


        i++
    }

    return result
}

fun main() {
    val input = listOf(
        intArrayOf(3, 1, 2, 5),
        intArrayOf(2, 3, 1),
        intArrayOf(11, 81, 94, 43, 3),
    )

    input.forEach {
        println(sumSubarrayMins(it))
    }
}