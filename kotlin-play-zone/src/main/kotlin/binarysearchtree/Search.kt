package `kotlin-play-zone`.src.main.kotlin.binarysearchtree

import `kotlin-play-zone`.src.main.kotlin.binarytree.TreeNode
import `kotlin-play-zone`.src.main.kotlin.binarytree.buildTree

fun search(root: TreeNode?, value: Int ): TreeNode? {
    if (root == null) {
        return null
    }

    return if (root.value == value) {
        root
    } else if (value > root.value!!) {
        search(root.right, value)
    } else {
        search(root.left, value)
    }
}

fun main() {
    val input = listOf(
        Pair(buildTree(arrayOf(4, 2, 7, 1, 3)), 2),
        Pair(buildTree(arrayOf(4, 2, 7, 1, 3)), 5),
        Pair(buildTree(arrayOf(10, 2, 12, 1, 4, null, null, null, null, 3)), 2),
    )

    input.forEach {
        println(search(it.first, it.second))
    }
}