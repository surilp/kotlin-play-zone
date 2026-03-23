package `kotlin-play-zone`.src.main.kotlin.binarytree

fun isTreeSame(root1: TreeNode?, root2: TreeNode?): Boolean {
    if (root1 == null && root2 == null) {
        return true
    }

    if (root1?.value != root2?.value) {
        return false
    }

    val result = isTreeSame(root1?.left, root2?.left)
    if (!result) {
        return false
    }
    return isTreeSame(root1?.right, root2?.right)
}

fun main() {
    val input = listOf(
        Pair(buildTree(arrayOf(1, 2, 3)), buildTree(arrayOf(1, 2, 3))),
        Pair(buildTree(arrayOf(1, 2, 1)), buildTree(arrayOf(1, 1, 2))),
        Pair(
            buildTree(arrayOf(5, 1, 2, 8, null, null, 5, null, 4, null, null, 7)),
            buildTree(arrayOf(5, 1, 2, 8, null, null, 4, null, 5, null, null, 7))
        ),
    )

    input.forEach {
        println(isTreeSame(it.first, it.second))
    }
}