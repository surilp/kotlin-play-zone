package `kotlin-play-zone`.src.main.kotlin.linkedlist

fun middle(head: Node<Int>): Node<Int>? {
    var slow: Node<Int>? = head
    var fast: Node<Int>? = head

    while (slow != null && fast != null && fast.next != null) {
        slow = slow.next
        fast = fast.next?.next
    }

    if (fast?.next == null) {
        return slow!!
    }

    return slow?.next
}

fun main() {
    val input = listOf(
        intArrayToLinkedList(intArrayOf(3, 8, 7, 1, 3)),
        intArrayToLinkedList(intArrayOf(2, 9, 1, 4, 0, 4)),
        intArrayToLinkedList(intArrayOf(3, 8, 1, 7, 0)),
    )

    input.forEach {
        val result = middle(it)
        println(result?.value)
    }
}
