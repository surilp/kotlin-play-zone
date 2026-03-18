package `kotlin-play-zone`.src.main.kotlin.linkedlist

fun deleteMiddle(head: Node<Int>): Node<Int> {
    if (head.next == null) {
        return head
    }

    var slow: Node<Int>? = head
    var fast: Node<Int>? = head
    var prevSlow: Node<Int>? = null

    while (fast != null && fast.next != null) {
        prevSlow = slow
        slow = slow?.next
        fast = fast.next?.next
    }

    prevSlow?.next = slow?.next
    slow?.next = null

    return head
}


fun main() {
    val input = listOf(
        intArrayToLinkedList(intArrayOf(3, 8, 7, 1, 3)),
        intArrayToLinkedList(intArrayOf(2, 9, 1, 4, 0, 4)),
        intArrayToLinkedList(intArrayOf(3, 8, 1, 7, 0)),
    )

    input.forEach {
        val result = deleteMiddle(it)
        println(traversal(result))
    }
}
