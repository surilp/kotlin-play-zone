package `kotlin-play-zone`.src.main.kotlin.linkedlist

class Node<T>(val value:T, var next: Node<T>? = null ) {
}

fun <T> Node<T>.print() {
    var temp: Node<T>? = this

    while (temp != null) {
        println(temp.value)
        temp = temp.next
    }
}