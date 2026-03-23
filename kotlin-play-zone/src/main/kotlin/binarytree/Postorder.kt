package `kotlin-play-zone`.src.main.kotlin.binarytree

fun postorder(root: TreeNode?): List<Int> {
    val result = mutableListOf<Int>()

    fun helper(node: TreeNode?) {
        if (node == null) {
            return
        }

        helper(node.left)
        helper(node.right)
        result.add(node.value!!)

    }

    helper(root)
    return result
}

fun main() {
    val input = listOf(
        buildTree(arrayOf(1, 4, null, 4, 2)),
        buildTree(arrayOf(1, null, 2, 3)),
        buildTree(arrayOf(5, 1, 2, 8, null, 4, 5, null, 6)),
    )

    input.forEach{
        println(postorder(it))
    }
}