package `1038_Binary_Search_Tree_to_Greater_Sum_Tree`

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class Solution {
    fun bstToGst(root: TreeNode?): TreeNode? {

        fun dfs(node: TreeNode?, sum: Int): Int {
            if (node == null)
                return 0

            val v1 = dfs(node.right, sum)
            node.`val` += v1 + sum
            val v2 = dfs(node.left, node.`val`)
            return node.`val`
        }

        dfs(root, 0)
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