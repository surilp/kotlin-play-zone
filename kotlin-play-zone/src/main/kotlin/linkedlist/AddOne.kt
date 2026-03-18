package `kotlin-play-zone`.src.main.kotlin.linkedlist

fun addOne(head: Node<Int>): Node<Int> {
    val reversedHead = reverse(head)

    var carry = 1
    var temp: Node<Int>? = reversedHead

    val resultHead = Node(-1)
    var dummy: Node<Int>? = resultHead

    while (temp != null) {
        val value = temp.value
        val sum = value + carry
        val digit = sum % 10
        carry = sum / 10

        val newNode = Node(digit)
        dummy?.next = newNode
        dummy = dummy?.next

        temp = temp.next
    }

    if (carry > 0) {
        dummy?.next = Node(carry)
    }

    val reverseResult = reverse(resultHead.next!!)

    return reverseResult
}

fun reverse(node: Node<Int>): Node<Int> {
    if (node.next == null) {
        return node
    }

    val newHead = reverse(node.next!!)
    val next = node.next
    next?.next = node
    node.next = null

    return newHead
}

fun addOneRecursive(node: Node<Int>): Node<Int> {

    fun helper(node: Node<Int>): Int {
        if (node.next == null) {
            val sum = node.value + 1
            val digit = sum % 10
            val carry = sum / 10

            node.value = digit
            return carry
        }

        var carry = helper(node.next!!)
        val sum = node.value + carry
        val digit = sum % 10
        carry = sum / 10
        node.value = digit

        return carry
    }

    val result = helper(node)

    if (result > 0) {
        val newNode = Node(result)
        newNode.next = node
        return newNode
    }

    return node
}

fun main() {
    val input = listOf(
        intArrayToLinkedList(intArrayOf(1, 2, 3, 4, 5)),
        intArrayToLinkedList(intArrayOf(6, 8)),
        intArrayToLinkedList(intArrayOf(1)),
        intArrayToLinkedList(intArrayOf(9, 9)),
        intArrayToLinkedList(intArrayOf(9)),
    )

    input.forEach {
        val result = addOneRecursive(it)
        print(traversal(result))
    }
}