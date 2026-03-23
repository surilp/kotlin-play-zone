package `kotlin-play-zone`.src.main.kotlin.stackqueue

class QueueWithStack {
    var stack1 = ArrayDeque<Int>()
    var stack2 = ArrayDeque<Int>()

    fun push(x: Int) {
        stack1.addLast(x)
    }

    fun pop(): Int {
        if (isEmpty()) {
            return -1
        }

        while (stack1.isNotEmpty()) {
            stack2.addLast(stack1.removeLast())
        }

        val result = stack2.removeLast()

        while (stack2.isNotEmpty()) {
            stack1.addLast(stack2.removeLast())
        }

        return result
    }

    fun peek(): Int {
        if (isEmpty()) {
            return -1
        }

        while (stack1.isNotEmpty()) {
            stack2.addLast(stack1.removeLast())
        }

        val result = stack2.last()

        while (stack2.isNotEmpty()) {
            stack1.addLast(stack2.removeLast())
        }

        return result
    }

    fun isEmpty(): Boolean {
        return stack1.size == 0 && stack2.size == 0
    }

}

fun main() {
    val stack = QueueWithStack()
    stack.push(4)
    stack.push(8)
    println(stack.pop())
    println(stack.peek())
    println(stack.isEmpty())
}