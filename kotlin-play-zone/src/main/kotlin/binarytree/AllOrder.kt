package `kotlin-play-zone`.src.main.kotlin.binarytree

fun allOrder(root: TreeNode?): List<List<Int>> {
    val result = mutableListOf<List<Int>>()
    val preOrder = mutableListOf<Int>()
    val inOrder = mutableListOf<Int>()
    val postOrder = mutableListOf<Int>()

    fun helper(node: TreeNode?) {
        if (node == null) {
            return
        }
        preOrder.add(node.value!!)
        helper(node.left)
        inOrder.add(node.value)
        helper(node.right)
        postOrder.add(node.value)
    }

    helper(root)

    result.addLast(inOrder)
    result.addLast(preOrder)
    result.addLast(postOrder)

    return result
}

fun main() {
    val input = listOf(
        buildTree(arrayOf(1, 3, 4, 5, 2, 7, 6)),
        buildTree(arrayOf(1, 2, 3, null, null, null, 6)),
        buildTree(arrayOf(5, 1, 2, 8, null, 4, 5, null, 6)),
    )

    input.forEach{
        println(allOrder(it))
    }
}
