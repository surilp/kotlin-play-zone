package `kotlin-play-zone`.src.main.kotlin.linkedlist

fun isPalindrome(head: Node<Int>): Boolean {
    if (head.next == null) {
        return true
    }

    fun middle(head: Node<Int>): Node<Int> {
        var slow: Node<Int>? = head
        var fast: Node<Int>? = head

        while (fast != null && fast.next != null) {
            slow = slow?.next
            fast = fast.next?.next
        }

        if (fast != null) {
            return slow?.next!!
        }

        return slow!!
    }

    val midNode = middle(head)
    var temp1: Node<Int>? = head
    var temp2: Node<Int>? = reverse(midNode)
    var reversedNode = temp2


    while (temp2 != null && temp1 != null) {
        if (temp2.value != temp1.value) {
            reverse(reversedNode!!)
            println(traversal(head))
            return false
        }
        temp2 = temp2.next
        temp1 = temp1.next
    }


    reverse(reversedNode!!)
    println(traversal(head))

    return true
}

fun main() {
    val input = listOf(
        intArrayToLinkedList(intArrayOf(3, 7, 5, 7, 3)),
        intArrayToLinkedList(intArrayOf(1, 1, 2, 1)),
        intArrayToLinkedList(intArrayOf(9, 9, 9, 9)),
    )

    input.forEach {
        val result = isPalindrome(it)
        println(result)
    }
}
