package `110_Balanced_Binary_Tree`

import kotlin.math.abs
import kotlin.math.max

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class Solution {
    fun getDepth(root: TreeNode?): Int? {
        if (root == null) return 0
        val leftDepth = getDepth(root.left)
        val rightDepth = getDepth(root.right)
        if (leftDepth == null || rightDepth == null) return null
        if (abs(leftDepth - rightDepth) > 1) return null
        return max(leftDepth, rightDepth) + 1
    }

    fun isBalanced(root: TreeNode?): Boolean {
        if (root == null) {
            return true
        }
        val left = getDepth(root.left)
        val right = getDepth(root.right)
        if (left == null || right == null) return false
        return abs(left - right) <= 1
    }
}

fun main(args: Array<String>) {
    val tree = TreeNode(1)
    tree.left = TreeNode(2)
    tree.right = TreeNode(2)
    tree.left!!.left = TreeNode(3)
    tree.left!!.right = TreeNode(3)
    tree.left!!.left!!.left = TreeNode(4)
    tree.left!!.left!!.right = TreeNode(4)
    val solution = Solution()
    val a = solution.isBalanced(tree)
    val b = 1
}