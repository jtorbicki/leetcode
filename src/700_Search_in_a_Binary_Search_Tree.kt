package `700_Search_in_a_Binary_Search_Tree`

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class Solution {
    fun searchBST(root: TreeNode?, `val`: Int): TreeNode? {
        return root?.let {
            when {
                `val` == root.`val` -> root
                `val` < root.`val` -> searchBST(root.left, `val`)
                else -> searchBST(root.right, `val`)
            }
        }
    }
}