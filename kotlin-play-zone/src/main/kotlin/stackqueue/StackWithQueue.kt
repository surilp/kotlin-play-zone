package `kotlin-play-zone`.src.main.kotlin.stackqueue

class StackWithQueue {
    var queue1 = ArrayDeque<Int>()
    var queue2 = ArrayDeque<Int>()

    fun push(x: Int) {
        queue1.addLast(x)
    }

    fun pop(): Int {
        if (isEmpty()) {
            return -1
        }

        while (queue1.size != 1) {
            queue2.addLast(queue1.removeFirst())
        }

        val result = queue1.removeFirst()

        queue1 = queue2.also { queue2 = queue1 }

        return result
    }

    fun top(): Int {
        if (isEmpty()) {
            return -1
        }

        while (queue1.size != 1) {
            queue2.addLast(queue1.removeFirst())
        }

        val result = queue1.removeFirst()

        queue2.addLast(result)

        queue1 = queue2.also { queue2 = queue1 }

        return result
    }

    fun isEmpty(): Boolean {
        return queue1.size == 0 && queue2.size == 0
    }

}

fun main() {
    val stack = StackWithQueue()
    stack.push(4)
    stack.push(8)
    println(stack.pop())
    println(stack.top())
    println(stack.isEmpty())
}