package `199_Binary_Tree_Right_Side_View`

import java.util.TreeMap

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class Solution {

    fun rightSideView(root: TreeNode?): List<Int> {

        val tree = TreeMap<Int, Int>()

        fun dfs(index: Int, root: TreeNode?) {
            if (root == null) return
            tree[index] = root.`val`
            dfs(index + 1, root.left)
            dfs(index + 1, root.right)
        }

        dfs(0, root)
        return tree.values.toList()
    }
}

fun main() {
    val tree = TreeNode(1)
    tree.left = TreeNode(2)
    tree.left!!.right = TreeNode(5)
    tree.right = TreeNode(3)
    tree.right!!.right = TreeNode(4)

    val solution = Solution()
    solution.rightSideView(tree).let { println(it) }
}