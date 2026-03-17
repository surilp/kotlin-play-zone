package `kotlin-play-zone`.src.main.kotlin.linkedlist

fun traversal(head: Node<Int>): List<Int> {
    val result = mutableListOf<Int>()

    var temp: Node<Int>? = head

    while (temp != null) {
        result.add(temp.value)
        temp = temp.next
    }

    return result
}

fun main() {
    // Example 1: [5, 4, 3, 1, 0]
    val head1 = Node(5)
    head1.next = Node(4)
    head1.next?.next = Node(3)
    head1.next?.next?.next = Node(1)
    head1.next?.next?.next?.next = Node(0)
    println(traversal(head1)) // [5, 4, 3, 1, 0]

    // Example 2: [1]
    val head2 = Node(1)
    println(traversal(head2)) // [1]

    // Your turn: [0, 2, 5]
    val head3 = Node(0)
    head3.next = Node(2)
    head3.next?.next = Node(5)
    println(traversal(head3)) // [0, 2, 5]
}
