package `kotlin-play-zone`.src.main.kotlin.linkedlist

fun removeNthFromEnd(head: Node<Int>, n: Int): Node<Int> {
    var front: Node<Int>? = head
    var back: Node<Int>? = head
    var prev: Node<Int>? = null

    var i = 0
    while (front != null) {
        i++
        if (i == n) {
            break
        }
        front = front.next
    }

    while (front != null && front.next != null) {
        front = front.next
        prev = back
        back = back?.next
    }

    if (head == back) {
        return head.next!!
    }

    prev?.next = back?.next
    back?.next = null

    return head
}

fun main() {
    val input = listOf(
        Pair(intArrayToLinkedList(intArrayOf(1,2,3,4,5)), 2),
        Pair(intArrayToLinkedList(intArrayOf(5,4,3,2,1)), 5),
        Pair(intArrayToLinkedList(intArrayOf(9,8,7)), 1),
    )

    input.forEach {
        val result = removeNthFromEnd(it.first, it.second)
        println(traversal(result))
    }
}
