package `236_Lowest_Common_Ancestor_of_a_Binary_Tree`

import java.util.TreeMap

class TreeNode(var `val`: Int = 0) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class Solution {
    fun lowestCommonAncestor(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {

        fun dfs(node: TreeNode?): TreeNode? {
            if (node == null) return null

            if (node == p || node == q)
                return node

            val l = dfs(node.left)
            val r = dfs(node.right)

            return when {
                l != null && r != null -> node
                l != null -> l
                else -> r
            }
        }

        return dfs(root)
    }
}

fun main() {
    val s = Solution()
    val tree = TreeNode(2)
    tree.left = TreeNode(1)
    tree.right = TreeNode(3)
    s.lowestCommonAncestor(tree, tree.left, tree.right)
}