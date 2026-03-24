package `kotlin-play-zone`.src.main.kotlin.binarysearchtree

import `kotlin-play-zone`.src.main.kotlin.binarytree.TreeNode
import `kotlin-play-zone`.src.main.kotlin.binarytree.buildTree

fun kLargestSmallest(root: TreeNode?, k: Int):Pair<Int?, Int?> {

    var counter = 0

    fun smallest(root: TreeNode?): Int? {
        if (root == null) {
            return null
        }

        val left = smallest(root.left)
        if (left != null) {
            return left
        }
        counter++
        if (counter == k) {
            return root.value
        }
        return smallest(root.right)
    }

    var counter2 = 0
    fun largest(root: TreeNode?): Int? {
        if (root == null) {
            return null
        }

        val left = largest(root.right)
        if (left != null) {
            return left
        }
        counter2++
        if (counter2 == k) {
            return root.value
        }
        return largest(root.left)
    }

    return Pair(smallest(root), largest(root))
}


fun main() {
    val input = listOf(
        Pair(buildTree(arrayOf(3,1,4,null,2)), 1),
        Pair(buildTree(arrayOf(5, 3, 6, 2, null, null, null, 1)), 3),
        Pair(buildTree(arrayOf(3,1,4,null,2)), 2),
    )

    input.forEach {
        println(kLargestSmallest(it.first, it.second))
    }
}