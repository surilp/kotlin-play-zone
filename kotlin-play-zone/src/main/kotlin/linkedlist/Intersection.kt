package `kotlin-play-zone`.src.main.kotlin.linkedlist

fun intersectionNode(head1: Node<Int>, head2: Node<Int>): Node<Int>? {
    var temp1: Node<Int>? = head1
    var temp2: Node<Int>? = head2

    while (temp1 != null && temp2 != null) {
        if (temp1 == temp2) {
            return temp1
        }

        temp1 = temp1.next
        temp2 = temp2.next

        if (temp1 == null && temp2 == null) {
            return null
        }


        if (temp1 == null) {
            temp1 = head2
        }

        if (temp2 == null) {
            temp2 = head1
        }
    }
    return null
}

fun main() {
    val head1 = Node(1)
    head1.next = Node(2)
    head1.next?.next = Node(3)
    val intersection = Node(4)
    head1.next?.next?.next = intersection
    val head2 = Node(7)
    head2.next = Node(8)
    head2.next?.next = intersection

    println(intersectionNode(head1, head2)?.value)


    val head3 = Node(1)
    head1.next = Node(2)
    head1.next?.next = Node(3)

    val head4 = Node(8)
    head2.next = Node(9)
    head2.next?.next = intersection

    println(intersectionNode(head3, head4)?.value)


    val head5 = Node(4)
    head1.next = Node(5)
    head1.next?.next = Node(6)
    val intersection3 = Node(4)
    val head6 = intersection3


    println(intersectionNode(head5, head6)?.value)
}

