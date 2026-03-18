package `kotlin-play-zone`.src.main.kotlin.linkedlist

import java.util.IdentityHashMap

fun loopLength(head: Node<Int>?): Int {
    if (head == null) {
        return -1
    }

    val hashMap = IdentityHashMap<Node<Int>, Int>()

    var temp = head
    var counter = 0

    while (temp != null) {
        counter++

        if (temp in hashMap) {
            val value = hashMap[temp] ?: 0
            return counter - value
        }

        hashMap[temp] = counter
        temp = temp.next
    }

    return -1
}

fun loopLengthOptimal(head: Node<Int>?): Int {
    if (head == null) {
        return -1
    }

    var slow: Node<Int>? = head
    var fast: Node<Int>? = head

    while (slow != null && fast != null && fast.next != null) {
        slow = slow.next
        fast = fast.next?.next

        if (slow == fast) {
            var counter = 1

            fast = fast?.next
            while(fast != slow) {
                counter++
                fast = fast?.next
            }
            return counter
        }
    }

    return -1
}

fun main() {
    val n1 = Node(1); val n2 = Node(2); val n3 = Node(3)
    val n4 = Node(4); val n5 = Node(5); val n6 = Node(6)
    val n7 = Node(7); val n8 = Node(8); val n9 = Node(9)

    n1.next = n2
    n2.next = n3
    n3.next = n4
    n4.next = n5
    n5.next = n6
    n6.next = n7
    n7.next = n8
    n8.next = n9
    n9.next = n3  // cycle back to node 3 (index 2)

    println(loopLengthOptimal(n1))   // 6 (3->4->5->6->7->8->9->3, length 7... wait, 3,4,5,6,7,8,9 = 7 nodes)

    val s1 = Node(1); val s2 = Node(2); val s3 = Node(3)
    val s4 = Node(4); val s5 = Node(5)
    s1.next = s2; s2.next = s3; s3.next = s4; s4.next = s5
    s5.next = s2  // cycle to index 1
    println("Example 1: ${loopLengthOptimal(s1)}")  // true

    // Example 2: 1 -> 3 -> 7 -> 4, no cycle, expected: false
    val m1 = Node(1); val m2 = Node(3); val m3 = Node(7); val m4 = Node(4)
    m1.next = m2; m2.next = m3; m3.next = m4
    println("Example 2: ${loopLengthOptimal(m1)}")  // false

    // Example 3 (your turn): 6 -> 3 -> 7 -> (back to 6), expected: true
    val p1 = Node(6); val p2 = Node(3); val p3 = Node(7)
    p1.next = p2; p2.next = p3
    p3.next = p1  // cycle to index 0
    println("Example 3: ${loopLengthOptimal(p1)}")  // true
}
