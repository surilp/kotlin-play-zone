package `kotlin-play-zone`.src.main.kotlin.linkedlist

fun deleteHead(head: Node<Int>): Node<Int>? {
    return head.next
}

fun main() {
    // Example 1: [5, 4, 3, 1, 0]
    val head1 = Node(5)
    head1.next = Node(4)
    head1.next?.next = Node(3)
    head1.next?.next?.next = Node(1)
    head1.next?.next?.next?.next = Node(0)
    println(deleteHead(head1)) // [5, 4, 3, 1, 0]

    // Example 2: [1]
    val head2 = Node(1)
    println(deleteHead(head2)) // [1]

    // Your turn: [0, 2, 5]
    val head3 = Node(0)
    head3.next = Node(2)
    head3.next?.next = Node(5)
    println(deleteHead(head3)) // [0, 2, 5]
}
