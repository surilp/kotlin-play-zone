package `kotlin-play-zone`.stackqueue

import kotlin.math.abs

fun asteroidCollision(asteroids: IntArray): List<Int> {
    val stack = ArrayDeque<Int>()

    for (asteroid in asteroids) {

        stack.addLast(asteroid)

        while (stack.isNotEmpty()) {
//            println(stack)
            val top = stack.removeLast()

            if (stack.isEmpty()) {
                stack.addLast(top)
                break
            }

            if ((top > 0 && stack.last() > 0) || (top < 0 && stack.last() < 0)) {
                stack.addLast(top)
                break
            }

            if (top + stack.last() == 0) {
                stack.removeLast()
                break
            }


            if (top > 0 && stack.last() < 0) {
                if (abs(stack.last()) < top) {
                    stack.removeLast()
                    stack.addLast(top)
                }
            }

            if (top < 0 && stack.last() > 0) {
                if (abs(top) > stack.last()) {
                    stack.removeLast()
                    stack.addLast(top)
                }
            }

        }
    }

    return stack.toList()
}

fun main() {
    val input = listOf(
        intArrayOf(1, 2, 3, -4, -2),
        intArrayOf(5, 10, -5, -10, 8, -8, -3, 12),
        intArrayOf(10, 2, -5),
        intArrayOf(4, 7, 1, 1, 2, -3, -7, 17, 15, -16),


    )

    input.forEach {
        println(asteroidCollision(it))
    }
}