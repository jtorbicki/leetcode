package `617_Merge_Two_Binary_Trees`

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class Solution {
    fun mergeTrees(root1: TreeNode?, root2: TreeNode?): TreeNode? {
        return when {
            root1 == null && root2 == null -> null
            root1 != null && root2 == null -> root1
            root1 == null && root2 != null -> root2
            root1 != null && root2 != null -> {
                val node = TreeNode(root1.`val` + root2.`val`)
                node.left = mergeTrees(root1.left, root2.left)
                node.right = mergeTrees(root1.right, root2.right)
                node
            }
            else -> null
        }
    }
}
