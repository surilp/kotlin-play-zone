package `kotlin-play-zone`.src.main.kotlin.binarytree

import kotlin.math.max

fun maxDepth(root: TreeNode?): Int {

    fun helper(node: TreeNode?): Int {
        if (node == null) {
            return 0
        }

        return 1 + maxOf(helper(node.left), helper(node.right))
    }

    return helper(root)
}

fun main() {
    val input = listOf(
        buildTree(arrayOf(1, 2, 3, null, null, null , 6)),
        buildTree(arrayOf(3, 9, 20, null, null, 15 , 7)),
        buildTree(arrayOf(5, 1, 2, 8, null, null, 5, null, 4, null, null, 7)),
    )

    input.forEach {
        println(maxDepth(it))
    }
}