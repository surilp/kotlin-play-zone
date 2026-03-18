package `kotlin-play-zone`.src.main.kotlin.linkedlist

fun reverseList(head: Node<Int>): Node<Int> {
    var prev: Node<Int>? = null
    var current: Node<Int>? = head
    var next: Node<Int>? = head.next

    while(current != null) {
        next = current.next
        current.next = prev
        prev = current
        current = next
    }

    return prev!!
}

fun recursive(head: Node<Int>): Node<Int> {

    fun helper(node: Node<Int>): Pair<Node<Int>, Node<Int>?> {
        if (node.next == null) {
            return Pair(node, null)
        }

        val (result, temp) =  helper(node.next!!)
        if (temp == null) {
            result.next = node
        } else {
            temp.next = node
        }

        node.next =null

        return Pair(result, node)
    }


    return helper(head).first

}

fun main() {
    val input = listOf(
        intArrayToLinkedList(intArrayOf(1, 2, 3, 4, 5)),
        intArrayToLinkedList(intArrayOf(6, 8)),
        intArrayToLinkedList(intArrayOf(1)),
    )

    input.forEach {
        val result = recursive(it)
        print(traversal(result))
    }
}
