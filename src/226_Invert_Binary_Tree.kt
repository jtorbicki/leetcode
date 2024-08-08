package `226_Invert_Binary`

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class Solution {
    fun invertTree(root: TreeNode?): TreeNode? {
        val left = root?.left
        val right = root?.right

        root?.left = right?.let {
            invertTree(it)
        }
        root?.right = left?.let {
            invertTree(it)
        }
        return root
    }
}

fun main() {
    val tree = TreeNode(2)
    tree.left = TreeNode(1)
    tree.right = TreeNode(3)
    val a = Solution().invertTree(tree)
    val b = 1
}
