package `124_Binary_Tree_Maximum_Path_Sum`

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class Solution {
    fun maxPathSum(root: TreeNode?): Int {
        var max = root?.`val` ?: 0

        fun dfs(node: TreeNode?): Int {
            if (node == null)
                return 0

            val l = maxOf(dfs(node.left), 0)
            val r = maxOf(dfs(node.right), 0)

            max = maxOf(max, node.`val` + l + r)
            return node.`val` + maxOf(l, r)
        }

        dfs(root)
        return max
    }
}



fun main() {
    val s = Solution()
    val tree = TreeNode(1)
    tree.left = TreeNode(-2)
    tree.right = TreeNode(-3)
    tree.left!!.left = TreeNode(1)
    tree.left!!.right = TreeNode(3)
    tree.left!!.left!!.left = TreeNode(-1)
    tree.right!!.left = TreeNode(-2)
    s.maxPathSum(tree).also { println(it) }
}
