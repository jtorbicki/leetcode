package `98_Validate_Binary_Search_Tree`

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class Solution {
    fun isValidBST(root: TreeNode?): Boolean {
        if (root == null) return true
        return (root.left?.let { it.`val` < root.`val` && isValidBST(root.left) } ?: true) &&
                (root.right?.let { it.`val` > root.`val` && isValidBST(root.right) } ?: true)
    }
}
