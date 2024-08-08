package `543_Diameter_of_Binary_Tree`

import kotlin.math.max

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class Solution {

    var diameter = 0

    fun dfs(root: TreeNode?): Int {
        if (root == null) return -1
        val dl = dfs(root.left)
        val dr = dfs(root.right)
        val d = dl + dr + 2
        diameter = max(diameter, d)
        return 1 + max(dl, dr)
    }

    fun diameterOfBinaryTree(root: TreeNode?): Int {
        dfs(root)
        return diameter
    }
}

fun main(args: Array<String>) {
    val tree = TreeNode(3)
    tree.left = TreeNode(2)
    tree.right = TreeNode(4)
    tree.left!!.left = TreeNode(1)
    tree.right!!.left = TreeNode(5)
    Solution().diameterOfBinaryTree(tree).let { println(it) }
}
