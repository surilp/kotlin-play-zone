package `kotlin-play-zone`.src.main.kotlin.linkedlist

fun insertKthElement(head: Node<Int>?, k: Int, value: Int): Node<Int>? {

    if (head == null && k > 1) {
        return null
    }

    if (k == 1) {
        val result = Node(value)
        result.next = head
        return result
    }

    var counter = 0
    var temp: Node<Int>? = head
    var prev: Node<Int>? = null

    while (temp != null) {
        counter++

        if (counter == k) {
            val new = Node(value)
            prev?.next = new
            new.next = temp
            break

        }
        if (counter > k) {
            return head
        }

        prev = temp
        temp = temp.next
    }

    if (counter + 1 == k) {
        val new = Node(value)
        prev?.next = new
        new.next = null
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
    println(traversal(insertKthElement(head1, 6, 6)!!)) // [5, 4, 3, 1, 0]
}