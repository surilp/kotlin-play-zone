package `kotlin-play-zone`.src.main.kotlin.binarysearchtree

import `kotlin-play-zone`.src.main.kotlin.binarytree.TreeNode
import `kotlin-play-zone`.src.main.kotlin.binarytree.buildTree

fun lca(root: TreeNode?, p: Int, q: Int): TreeNode? {

    val low = minOf(p, q)
    val high = maxOf(p, q)

    fun helper(node: TreeNode?, low: Int, high: Int): TreeNode? {
        if (node == null) {
            return null
        }

        val value = node.value!!
        return if (value in (low + 1)..<high) {
            node
        } else if (low < value && high < value ) {
            helper(node.left, low, high)
        } else {
            helper(node.right, low, high)
        }

    }

    return helper(root, low, high)
}

fun main() {
    val input = listOf(
        listOf(buildTree(arrayOf(5, 3, 6, 2, 4, null, 7)),2, 4),
        listOf(buildTree(arrayOf(5, 3, 6, 2, 4, null, 7)),2, 7),
        listOf(buildTree(arrayOf(2, 1, 4, null, null, 3, 6)),1, 6),
    )

    input.forEach {
        println(lca(it[0] as TreeNode?, it[1] as Int, it[2] as Int)?.value)
    }
}