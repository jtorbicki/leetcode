package `98_Validate_Binary_Search_Tree`

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class Solution {

    private var value: Int? = null

    private fun dfs(node: TreeNode?): Boolean {
        if (node == null)
            return true

        if (!dfs(node.left))
            return false

        val v = value
        when  {
            v == null || v < node.`val` -> value = node.`val`
            else -> return false
        }

        if (!dfs(node.right))
            return false

        return true
    }

    fun isValidBST(root: TreeNode?): Boolean {
        return dfs(root)
    }
}

fun main() {
    val s = Solution()
    val tree = TreeNode(2)
    tree.left = TreeNode(1)
    tree.right = TreeNode(0)
    s.isValidBST(tree).also { println(it) }
}