package `kotlin-play-zone`.src.main.kotlin.binarytree

import kotlin.math.abs

fun isBalanced(root: TreeNode?): Boolean {

    fun helper(node: TreeNode?): Pair<Int, Boolean> {
        if (node == null) {
            return Pair(0, true)
        }

        val (heightLeft, balancedLeft) = helper(node.left)
        if (!balancedLeft) {
            return Pair(heightLeft, false)
        }
        val (heightRight, balancedRight) = helper(node.right)
        if (!balancedRight) {
            return Pair(heightLeft, false)
        }
        val height = maxOf(heightRight, heightLeft) + 1
        if (abs(heightRight - heightLeft) > 1 ) {
            return Pair(height, false)
        } else {
            return Pair(height, true)
        }
    }

    return helper(root).second
}

fun main() {
    val input = listOf(
        buildTree(arrayOf(3, 9, 20, null, null, 15, 7)),
        buildTree(arrayOf(1, 2, null, null, 3)),
        buildTree(arrayOf(5, 1, 2, 8, 3, null, 5, null, 4)),
    )

    input.forEach {
        println(isBalanced(it))
    }
}