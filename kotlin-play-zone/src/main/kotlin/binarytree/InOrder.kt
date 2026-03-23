package `kotlin-play-zone`.src.main.kotlin.binarytree

fun inorderTraversal(root: TreeNode?): List<Int> {
    val result = mutableListOf<Int>()

    fun helper(node: TreeNode?) {
        if (node == null) {
            return
        }

        helper(node.left)
        result.add(node.value!!)
        helper(node.right)

    }

    helper(root)

    return result
}

fun iterative(root: TreeNode?): List<Int> {
    val stack = ArrayDeque<NodeState>()
    val result = mutableListOf<Int>()
    if (root == null) {
        return emptyList()
    }

    stack.addLast(NodeState(root, false))

    while(stack.isNotEmpty()) {
        val nodeState = stack.last()
        val node = nodeState.node
        val visited = nodeState.visited
        if (visited) {
            result.add(node.value!!)
            stack.removeLast()
            node.right?.let {
                stack.addLast(NodeState(node.right!!, false))
            }
        } else {
            nodeState.visited = true
            node.left?.let {
                stack.addLast(NodeState(node.left!!, false))
            }
        }
    }

    return result
}

data class NodeState(val node: TreeNode, var visited: Boolean)

fun main() {
    val input = listOf(
        buildTree(arrayOf(1,null,2,3)),
        buildTree(arrayOf(1,2,3,4,5,null,8,null,null,6,7,9)),
        buildTree(arrayOf()),
    )

    input.forEach{
        println(iterative(it))
    }
}