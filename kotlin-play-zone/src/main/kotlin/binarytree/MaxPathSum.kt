package `kotlin-play-zone`.src.main.kotlin.binarytree

fun maxPathSum(root: TreeNode?): Int {
    var result = Int.MIN_VALUE

    fun helper(node: TreeNode?): Int {
        if (node == null) {
            return 0
        }

        val left = helper(node.left)
        val right = helper(node.right)

        result = maxOf(result, left + right + node.value!!)

        return maxOf(left + node.value, right + node.value)
    }

    helper(root)
    return result
}

fun main() {
    val input = listOf(
        buildTree(arrayOf(20, 9, -10, null, null, 15, 7)),
        buildTree(arrayOf(-10, 9, 20, null, null, 15, 7)),
        buildTree(arrayOf(1, 2, 3, null, 4)),
    )

    input.forEach{
        println(maxPathSum(it))
    }
}