package `111Minimum_Depth_of_Binary_Tree`

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class Solution {
    fun minDepth(root: TreeNode?): Int {
        if (root == null)
            return 0

        if (root.left == null && root.right == null) {
            return 1
        }

        val leftDepth = root.left?.let { minDepth(it) }
        val rightDepth = root.right?.let { minDepth(it) }

        return listOfNotNull(leftDepth, rightDepth).min() + 1
    }
}
