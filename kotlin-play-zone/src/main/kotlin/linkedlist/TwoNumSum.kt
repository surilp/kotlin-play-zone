package `kotlin-play-zone`.src.main.kotlin.linkedlist

fun twoNumSum(node1: Node<Int>, node2: Node<Int>): Node<Int>? {

    var result: Node<Int>? = null

    var temp1: Node<Int>? = node1
    var temp2: Node<Int>? = node2
    var temp3: Node<Int>? = null
    var rem = 0

    while (temp1 != null && temp2 != null) {
        val firstVal = temp1.value
        val secondVal = temp2.value

        val sum = firstVal + secondVal + rem
        val res = sum % 10
        rem = sum / 10

        val node = Node(res)
        if (result == null) {
            result = node
        } else {
            temp3!!.next = node
        }

        temp1 = temp1.next
        temp2 = temp2.next
        temp3 = node
    }

    if (rem > 0) {
        temp3!!.next = Node(rem)
    }

    return result
}


fun main() {
    val node11 = Node(9)
    val node12 = Node(9)
    val node13 = Node(9)

    node11.next = node12
    node12.next = node13

    val node21 = Node(9)
    val node22 = Node(9)
    val node23 = Node(9)

    node21.next = node22
    node22.next = node23

    val result =  twoNumSum(node11, node21)
    result?.print()
}
