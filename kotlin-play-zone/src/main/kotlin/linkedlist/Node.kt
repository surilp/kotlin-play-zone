package `kotlin-play-zone`.src.main.kotlin.linkedlist

data class Node<T>(var value:T, var next: Node<T>? = null ) {
}

fun <T> Node<T>.print() {
    var temp: Node<T>? = this

    while (temp != null) {
        println(temp.value)
        temp = temp.next
    }
}

fun intArrayToLinkedList(nums: IntArray): Node<Int> {
    var result: Node<Int>? = null
    var temp: Node<Int>? = null

    for (num in nums) {
        if (result == null || temp == null) {
            result = Node(num)
            temp = result
        } else {
            temp.next = Node(num)
            temp = temp.next
        }
    }

    return result!!
}