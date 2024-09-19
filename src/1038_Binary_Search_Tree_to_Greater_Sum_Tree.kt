package `1038_Binary_Search_Tree_to_Greater_Sum_Tree`

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class Solution {
    fun bstToGst(root: TreeNode?): TreeNode? {

        var sum = 0

        fun dfs(node: TreeNode?) {
            if (node == null) return

            dfs(node.right)
            sum += node.`val`
            node.`val` = sum
            dfs(node.left)
        }

        dfs(root)
        return root
    }
}

fun main() {
    val s = Solution()
    val tree = TreeNode(4)
    tree.right = TreeNode(6)
    tree.left = TreeNode(1)
    s.bstToGst(tree)
}