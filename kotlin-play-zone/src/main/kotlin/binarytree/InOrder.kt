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

fun main() {
    val input = listOf(
        buildTree(arrayOf(1,null,2,3)),
        buildTree(arrayOf(1,2,3,4,5,null,8,null,null,6,7,9)),
        buildTree(arrayOf()),
    )

    input.forEach{
        println(inorderTraversal(it))
    }
}