package `563_Binary_Tree_Tilt`

import kotlin.math.abs

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class Solution {

    fun dfs(node: TreeNode?): Pair<Int, Int> {
        if (node == null) {
            return 0 to 0
        }

        val (leftSum, leftTilt) = node.left?.let { dfs(it) } ?: (0 to 0)
        val (rightSum, rightTilt) = node.right?.let { dfs(it) } ?: (0 to 0)

        val tilt = abs(leftSum - rightSum)
        return (leftSum + rightSum + node.`val`) to leftTilt + rightTilt + tilt
    }

    fun findTilt(root: TreeNode?): Int {
        return dfs(root).second
    }
}

