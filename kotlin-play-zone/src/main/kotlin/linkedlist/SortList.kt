package `kotlin-play-zone`.src.main.kotlin.linkedlist

fun sortList(head: Node<Int>?): Node<Int>? {
    if (head == null) {
        return null
    }

    val zeroHead = Node(-1)
    val oneHead = Node(-1)
    val twoHead = Node(-1)

    var tempZero: Node<Int>? = zeroHead
    var tempOne: Node<Int>? = oneHead
    var tempTwo: Node<Int>? = twoHead

    var temp = head

    while (temp != null) {
        when (temp.value) {
            0 -> {
                tempZero?.next = temp
                tempZero = tempZero?.next
            }
            1 -> {
                tempOne?.next = temp
                tempOne = tempOne?.next
            }
            2 -> {
                tempTwo?.next = temp
                tempTwo = tempTwo?.next
            }
            else -> throw Exception("Not valid")
        }
        temp = temp.next
    }
    tempZero?.next = null
    tempOne?.next = null
    tempTwo?.next = null

    tempZero?.next = oneHead.next
    tempOne?.next = twoHead.next

    return zeroHead.next
}

fun main() {
    val input = listOf(
        intArrayToLinkedList(intArrayOf(1, 0, 2, 0 , 1)),
        intArrayToLinkedList(intArrayOf(1, 1, 1, 0)),
        intArrayToLinkedList(intArrayOf(2, 2, 1, 2)),
    )

    input.forEach {
        val result = sortList(it)
        println(traversal(result!!))
    }
}