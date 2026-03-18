package `kotlin-play-zone`.src.main.kotlin.linkedlist

fun hasCycle(head: Node<Int>?): Boolean {
    if (head == null) {
        return false
    }

    if (head == head.next) {
        return true
    }

    var slow = head
    var fast = head.next?.next

    while (fast != null && fast.next != null) {
        if (fast == slow) {
            return true
        }

        slow = slow?.next
        fast = fast.next?.next
    }

    return false
}

fun meetingPoint(head: Node<Int>?): Node<Int>? {
    if (head == null) {
        return null
    }

    if (head == head.next) {
        return head
    }

    var slow = head.next
    var fast = head.next?.next

    while (fast != null && fast.next != null) {
        if (fast == slow) {
            break
        }

        slow = slow?.next
        fast = fast.next?.next
    }

    if (fast != slow) {
        return null
    }

    slow = head

    while (slow != fast) {
        slow = slow?.next
        fast = fast?.next
    }

    return slow
}

fun main() {
    // Example 1: 1 -> 2 -> 3 -> 4 -> 5 -> (back to 2), expected: true
    val n1 = Node(1); val n2 = Node(2); val n3 = Node(3)
    val n4 = Node(4); val n5 = Node(5)
    n1.next = n2; n2.next = n3; n3.next = n4; n4.next = n5
    n5.next = n2  // cycle to index 1
    println("Example 1: ${hasCycle(n1)}")  // true
    println("Example 1: ${meetingPoint(n1)?.value}")  // true

    // Example 2: 1 -> 3 -> 7 -> 4, no cycle, expected: false
    val m1 = Node(1); val m2 = Node(3); val m3 = Node(7); val m4 = Node(4)
    m1.next = m2; m2.next = m3; m3.next = m4
    println("Example 2: ${hasCycle(m1)}")  // false

    // Example 3 (your turn): 6 -> 3 -> 7 -> (back to 6), expected: true
    val p1 = Node(6); val p2 = Node(3); val p3 = Node(7)
    p1.next = p2; p2.next = p3
    p3.next = p1  // cycle to index 0
    println("Example 3: ${hasCycle(p1)}")  // true

    // Edge cases
    println("Null:        ${hasCycle(null)}")           // false
    println("Single node: ${hasCycle(Node(1))}")        // false
    val selfLoop = Node(1); selfLoop.next = selfLoop
    println("Self loop:   ${hasCycle(selfLoop)}")       // true
}
