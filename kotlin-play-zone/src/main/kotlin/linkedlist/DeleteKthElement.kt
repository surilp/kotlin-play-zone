package `kotlin-play-zone`.src.main.kotlin.linkedlist

fun deleteKthElement(head: Node<Int>?, k: Int): Node<Int>? {
    if (head == null || head.next == null) {
        return null
    }

    var current: Node<Int>? = head
    var prev: Node<Int> ?= null
    var i = 1

    while (current != null && i < k) {
        prev = current
        current = current.next
        i++
    }

    if (i != k) {
        println("can't delete")
        return head
    }

    prev?.next = current?.next
    return head
}

fun main() {
    // Example 1: [5, 4, 3, 1, 0]
    val head1 = Node(5)
    head1.next = Node(4)
    head1.next?.next = Node(3)
    head1.next?.next?.next = Node(1)
    head1.next?.next?.next?.next = Node(0)
    println(traversal(deleteKthElement(head1, 10)!!)) // [5, 4, 3, 1, 0]

    // Example 2: [1]
    val head2 = Node(1)
    println(deleteKthElement(head2, 1)) // [1]

    // Your turn: [0, 2, 5]
    val head3 = Node(0)
    head3.next = Node(2)
    head3.next?.next = Node(5)
    println(deleteKthElement(head3, 3)) // [0, 2, 5]
}
