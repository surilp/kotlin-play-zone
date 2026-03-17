package `kotlin-play-zone`.src.main.kotlin.linkedlist

fun addTwoNumbers(l1: Node<Int>, l2: Node<Int>): Node<Int> {
    var temp1: Node<Int>? = l1
    var temp2: Node<Int>? = l2

    var result: Node<Int>? = null
    var temp: Node<Int>? = null
    var rem = 0

    while (temp1 != null && temp2 != null) {
        val val1 = temp1.value
        val val2 = temp2.value

//        println("val1 $val1 val2 $val2")

        val sum = val1 + val2 + rem

        rem = sum / 10
        val digit = sum % 10

//        println("sum $sum rem $rem digit $digit")


        if (result == null) {
            result = Node(digit)
            temp = result
        } else {
            if (temp != null) {
                temp.next = Node(digit)
                temp = temp.next
            }
        }

        temp1 = temp1.next
        temp2 = temp2.next
    }

    temp1 = temp1 ?: temp2

    while (temp1 != null) {
        val val1 = temp1.value
        val sum = val1 + rem

        rem = sum / 10
        val digit = sum % 10

        temp!!.next = Node(digit)
        temp = temp.next

        temp1 = temp1.next
    }

    if (rem in 1..<10) {
        temp!!.next = Node(rem)
    } else if (rem >= 10) {
        temp!!.next = Node(rem)
        temp = temp.next
        temp!!.next = Node(1)
    }

    return result!!
}

fun main() {
    val input = listOf(
        Pair(intArrayOf(5, 4), intArrayOf(4)),
        Pair(intArrayOf(4, 5, 6), intArrayOf(1, 2, 3)),
        Pair(intArrayOf(1), intArrayOf(8, 7)),
        Pair(intArrayOf(9, 9, 9), intArrayOf(9, 9, 9)),
        Pair(intArrayOf(9, 9), intArrayOf(9, 9, 9)),
    )

    input.forEach {
        println(
            "For input ${it.first.contentToString()}, ${it.second.contentToString()}, result is ${
                traversal(
                    addTwoNumbers(
                        intArrayToLinkedList(it.first),
                        intArrayToLinkedList(it.second)
                    )
                )
            }"
        )
    }
}
