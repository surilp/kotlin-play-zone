package `kotlin-play-zone`.src.main.kotlin.binarytree

fun diameter(root: TreeNode?): Int {

    var result = 0

    fun helper(node: TreeNode?): Int {
        if (node == null) {
            return 0
        }

        val left = helper(node.left)
        val right = helper(node.right)

        result = maxOf(result, left + right)

        return maxOf(left, right) + 1
    }



    helper(root)
    return result
}

fun main() {
    val input = listOf(
        buildTree(arrayOf(1, 2, 3, 4, 5)),
        buildTree(arrayOf(1, 2, 3, null, 4, null, 5)),
        buildTree(arrayOf(5, 1, 2, 8, 3, null, 5, null, 4)),
    )

    input.forEach {
        println(diameter(it))
    }
}