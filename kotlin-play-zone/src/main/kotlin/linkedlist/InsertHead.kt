package `kotlin-play-zone`.src.main.kotlin.linkedlist

fun insertHead(head: Node<Int>?, value: Int): Node<Int> {
    if (head == null) {
        return Node(value)
    }

    val temp = Node(value)
    temp.next = head
    return temp
}

fun main() {
    // Example 1: [5, 4, 3, 1, 0]
    val head1 = Node(5)
    head1.next = Node(4)
    head1.next?.next = Node(3)
    head1.next?.next?.next = Node(1)
    head1.next?.next?.next?.next = Node(0)
    println(traversal(insertHead(head1, 6))) // [5, 4, 3, 1, 0]
}
