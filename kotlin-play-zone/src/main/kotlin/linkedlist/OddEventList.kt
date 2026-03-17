package `kotlin-play-zone`.src.main.kotlin.linkedlist

fun oddEventList (head: Node<Int>): Node<Int> {

    var dummyOddNode: Node<Int>? = Node(-1)
    var dummyEvenNode: Node<Int>? = Node(-1)

    var oddNodes = dummyOddNode
    var evenNodes = dummyEvenNode

    var oddNode: Node<Int>? = head
    var evenNode: Node<Int>? = head.next

    while (oddNode != null || evenNode != null) {
        println("odd ${oddNode?.value} even ${evenNode?.value} ")

        if (oddNode != null) {
            val odd = Node(oddNode.value)
            dummyOddNode?.next = odd
            dummyOddNode = dummyOddNode?.next
        }

        if (evenNode != null) {
            val even = Node(evenNode.value)
            dummyEvenNode?.next = even
            dummyEvenNode = dummyEvenNode?.next
        }

        oddNode = evenNode?.next
        evenNode = oddNode?.next

    }

    dummyOddNode?.next = evenNodes?.next

    return oddNodes?.next!!
}

fun main() {
    val input = listOf(
        intArrayToLinkedList(intArrayOf(1, 2, 3, 4, 5)),
        intArrayToLinkedList(intArrayOf(4, 3, 2, 1)),
        intArrayToLinkedList(intArrayOf(1)),
    )

    input.forEach {
        val result = oddEventList(it)
        print(traversal(result))
    }
}
