package `kotlin-play-zone`.src.main.kotlin.binarysearchtree

import `kotlin-play-zone`.src.main.kotlin.binarytree.TreeNode
import `kotlin-play-zone`.src.main.kotlin.binarytree.inorderTraversal

fun fromPreorder(preorder: IntArray): TreeNode? {
    var i = 1

    fun helper(max: Int): TreeNode? {
        if (i >= preorder.size) return null
        if (preorder[i] > max) return null

        val node = TreeNode(preorder[i])
        i++
        node.left = helper(node.value!!)
        node.right = helper(max)
        return node
    }

    return helper(Int.MAX_VALUE)

}

fun main() {
    val input = listOf(
        intArrayOf(8, 5, 1, 7, 10, 12),
        intArrayOf(1, 3),
        intArrayOf(5, 3, 2, 4, 6, 7),
    )

    input.forEach {
        println(inorderTraversal(fromPreorder(it)))
    }
}
