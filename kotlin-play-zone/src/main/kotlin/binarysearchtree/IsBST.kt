package `kotlin-play-zone`.src.main.kotlin.binarysearchtree

import `kotlin-play-zone`.src.main.kotlin.binarytree.TreeNode
import `kotlin-play-zone`.src.main.kotlin.binarytree.buildTree

fun isBST(root: TreeNode?): Boolean {

    if (root == null) {
        return true
    }

    fun helper(node: TreeNode?, min: Int, max: Int): Boolean {
        if (node == null) {
            return true
        }

        return if (node.value in (min + 1)..<max) {
            helper(node.left, min, node.value!!) &&
                    helper(node.right, node.value, max)
        } else {
            false
        }

    }

    return helper(root, Int.MIN_VALUE, Int.MAX_VALUE)
}

fun main() {
    val input = listOf(
        buildTree(arrayOf(5, 3, 6, 2, 4, null, 7)),
        buildTree(arrayOf(5, 3, 6, 4, 2, null, 7)),
        buildTree(arrayOf(2, 1, 3)),
    )

    input.forEach {
        println(isBST(it))
    }
}