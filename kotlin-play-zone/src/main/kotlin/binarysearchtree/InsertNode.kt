package `kotlin-play-zone`.src.main.kotlin.binarysearchtree

import `kotlin-play-zone`.src.main.kotlin.binarytree.TreeNode
import `kotlin-play-zone`.src.main.kotlin.binarytree.buildTree

fun insertNode(root: TreeNode?, value: Int): TreeNode? {
    var result: TreeNode? = null

    fun helper(node: TreeNode?, value: Int) {
        if (node == null) {
            return
        }

        if (node.left == null && node.right == null) {
            if (value < node.value!!) {
                node.left = TreeNode(value)
                result = node.left
            } else {
                node.right = TreeNode(value)
                result = node.right
            }
        }

        if (value > node.value!!) {
            helper(node.right, value)
        } else {
            helper(node.left, value)
        }
    }

    helper(root, value)
    return root
}

fun main() {
    val input = listOf(
        Pair(buildTree(arrayOf(4, 2, 7, 1, 3)), 5),
        Pair(buildTree(arrayOf(40, 20, 60, 10, 30, 50, 70)), 25),
        Pair(buildTree(arrayOf(4, 2, 7, 1, null, 6)), 3),
    )

    input.forEach {
        println(insertNode(it.first, it.second))
    }
}