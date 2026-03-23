package `kotlin-play-zone`.src.main.kotlin.binarytree

fun preOrder(root: TreeNode?): List<Int> {
    val result = mutableListOf<Int>()

    fun helper(node: TreeNode?) {
        if (node == null) {
            return
        }

        result.add(node.value!!)
        helper(node.left)
        helper(node.right)
    }

    helper(root)
    return result
}

fun iterativePreorder(root: TreeNode?): List<Int> {
    val stack = ArrayDeque<TreeNode>()
    var node = root
    val result = mutableListOf<Int>()

    while (true) {
        if (node != null) {
            result.add(node.value!!)
            stack.addLast(node)
            node = node.left
        } else {
            if (stack.isEmpty()) {
                break
            }
            node =stack.removeLast()
            node = node.right
        }
    }

    return result
}

fun main() {
    val input = listOf(
        buildTree(arrayOf(1, 4, null, 4, 2)),
        buildTree(arrayOf(1)),
        buildTree(arrayOf(5, 1, 2, 8, null, 4, 5, null, 6)),
    )

    input.forEach{
        println(iterativePreorder(it))
        println(preOrder(it))
    }
}