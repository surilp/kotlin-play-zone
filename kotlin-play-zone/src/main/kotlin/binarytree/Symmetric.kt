package `kotlin-play-zone`.src.main.kotlin.binarytree

fun isSymmetric(root: TreeNode?): Boolean {

    fun helper(left: TreeNode?, right: TreeNode?): Boolean {
        if (left == null && right == null) {
            return true
        }

        if (left?.value != right?.value) {
            return false
        }

        val l = helper(left?.left, right?.right)
        if (!l) {
            return false
        }

        return helper(left?.right, right?.left)

    }

    return helper(root?.left, root?.right)
}

fun main() {
    val input = listOf(
        buildTree(arrayOf(1, 2, 2, 3, 4, 4, 3)),
        buildTree(arrayOf(1, 2, 2, null, 3, null, 3)),
        buildTree(arrayOf(1, 2, 3)),
    )

    input.forEach {
        println(isSymmetric(it))
    }
}
