package `kotlin-play-zone`.src.main.kotlin.binarysearchtree

import `kotlin-play-zone`.src.main.kotlin.binarytree.TreeNode
import `kotlin-play-zone`.src.main.kotlin.binarytree.buildTree

fun floorCeil(root: TreeNode?, key: Int): Pair<Int, Int> {
    var floor = -1
    var ceil = -1

    fun helper(root:TreeNode?, key: Int) {
        if (root == null) {
            return
        }

        if (root.value == key) {
            floor = key
            ceil = key
        }

        if (key > root.value!!) {
            floor = root.value
            helper(root.right, key)
        } else {
            ceil = root.value
            helper(root.left, key)
        }
    }

    helper(root, key)

    return Pair(floor, ceil)
}

fun main() {
    val input = listOf(
        Pair(buildTree(arrayOf(8, 4, 12, 2, 6, 10, 14)), 11),
        Pair(buildTree(arrayOf(8, 4, 12, 2, 6, 10, 14)), 15),
        Pair(buildTree(arrayOf(8, 4, 12, 2, 6, 10, 14)), 1),
    )

    input.forEach {
        println(floorCeil(it.first, it.second))
    }
}