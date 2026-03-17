package `kotlin-play-zone`.src.main.kotlin.linkedlist

fun insertBeforeValueK(head: Node<Int>?, value: Int, k: Int): Node<Int>? {
    if (head == null) {
        return null
    }

    if (head.value == k) {
        val new = Node(value)
        new.next = head
        return new
    }

    var temp = head
    var prev: Node<Int>? = null

    while (temp != null) {
        if (temp.value == k) {
            val new = Node(value)
            prev?.next = new
            new.next = temp
            break
        }

        prev = temp
        temp = temp.next
    }


    return head
}

fun main() {
    // Example 1: [5, 4, 3, 1, 0]
    val head1 = Node(5)
    head1.next = Node(4)
    head1.next?.next = Node(3)
    head1.next?.next?.next = Node(1)
    head1.next?.next?.next?.next = Node(0)
    println(traversal(insertBeforeValueK(head1, 6, 1)!!)) // [5, 4, 3, 1, 0]
}
