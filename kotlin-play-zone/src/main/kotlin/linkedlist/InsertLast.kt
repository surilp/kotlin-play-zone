package `kotlin-play-zone`.src.main.kotlin.linkedlist

fun insertLast(head: Node<Int>?, value: Int): Node<Int> {
    if (head == null) {
        return Node(value)
    }

    var temp = head

    while (temp != null && temp.next != null) {
        temp = temp.next
    }

    temp?.next = Node(value)

    return head
}

fun main() {
    // Example 1: [5, 4, 3, 1, 0]
    val head1 = Node(5)
    head1.next = Node(4)
    head1.next?.next = Node(3)
    head1.next?.next?.next = Node(1)
    head1.next?.next?.next?.next = Node(0)
    println(traversal(insertLast(head1, 6))) // [5, 4, 3, 1, 0]
}
