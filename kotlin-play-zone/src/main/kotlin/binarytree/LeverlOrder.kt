package `kotlin-play-zone`.src.main.kotlin.binarytree

fun levelOrder(root: TreeNode?): List<List<Int>> {
    if (root == null) {
        return emptyList()
    }
    val queue = ArrayDeque<TreeNode>()
    queue.addLast(root)
    val result = mutableListOf<List<Int>>()
    while (queue.isNotEmpty()) {
        val temp = mutableListOf<Int>()
        var i = 0
        val n = queue.size
        while (i < n) {
            val node = queue.removeFirst()
            temp.add(node.value!!)
            node.left?.let { queue.addLast(it) }
            node.right?.let { queue.addLast(it) }
            i++
        }
        result.add(temp)
    }
    return result
}

fun main() {
    val input = listOf(
        buildTree(arrayOf(3, 9, 20, null, null, 15, 7)),
        buildTree(arrayOf(1, 4, null, 4, 2)),
        buildTree(arrayOf(5, 1, 2, 8, null, 4, 5, null, 6)),
    )

    input.forEach{
        println(levelOrder(it))
    }
}