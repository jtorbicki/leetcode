package `235_Lowest_Common_Ancestor_of_a_Binary_Search_Tree`

class TreeNode(var `val`: Int = 0) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class Solution {
    fun lowestCommonAncestor(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {
        if (root == null || p == null || q == null) return null
        if (root.`val` == p.`val` || root.`val` == q.`val`) {
            return root
        } else if (root.`val` > p.`val` && root.`val` < q.`val`) {
            return root
        } else if (root.`val` < p.`val` && root.`val` > q.`val`) {
            return root
        } else if (root.`val` < q.`val`) {
            return lowestCommonAncestor(root.right, p, q)
        }
        return lowestCommonAncestor(root.left, p, q)
    }
}

fun main(args: Array<String>) {
    val tree = TreeNode(2)
    tree.left = TreeNode(1)
    tree.right = TreeNode(3)
    val a = Solution().lowestCommonAncestor(tree, tree.right, tree.left)
    val b = 1
}
