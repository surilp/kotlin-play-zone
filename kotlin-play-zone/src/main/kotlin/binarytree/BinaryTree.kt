package `kotlin-play-zone`.src.main.kotlin.binarytree

import kotlin.math.pow

fun buildTree(array: Array<Int?>): TreeNode? {
    if (array.isEmpty() || array[0] == null) return null


    val rootNode = TreeNode(array[0])
    val queue = ArrayDeque<TreeNode>()
    queue.addLast(rootNode)

    var i = 1
    val n = array.size

    while (i < n) {
        val node = queue.removeFirst()

        array[i]?.let {
            node.left = TreeNode(it)
            queue.addLast(node.left!!)
        }
        i++

        if (i < n) {
            array[i]?.let {
                node.right = TreeNode(it)
                queue.addLast(node.right!!)
            }
            i++
        }
    }

    return rootNode
}


class TreeNode(val value: Int?, var left: TreeNode? = null, var right: TreeNode? = null)