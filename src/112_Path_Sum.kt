package `112_Path_Sum`

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class Solution {
    fun dfs(root: TreeNode?, targetSum: Int): Boolean {
        return when {
            root == null && targetSum == 0 -> true
            root == null && targetSum != 0 -> false
            root!!.left != null && root.right != null -> {
                dfs(root.left, targetSum - root.`val`) || dfs(root.right, targetSum - root.`val`)
            }
            root.left != null -> dfs(root.left, targetSum - root.`val`)
            else -> dfs(root.right, targetSum - root.`val`)
        }
    }

    fun hasPathSum(root: TreeNode?, targetSum: Int): Boolean {
        if (root == null && targetSum == 0) return false

        return dfs(root, targetSum)
    }
}

fun main() {
    val s = Solution()
    val tree = TreeNode(1)
    tree.left = TreeNode(2)
    s.hasPathSum(tree, 1).also { println(it) }
}