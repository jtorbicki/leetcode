package `1448_Count_Good_Nodes_in_Binary_Tree`

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class Solution {
    fun goodNodes(root: TreeNode?): Int {
        fun dfs(node: TreeNode?, max: Int): Int {
            if (node == null) return 0
            val newMax = maxOf(max, node.`val`)

            return dfs(node.left, newMax) + dfs(node.right, newMax) + if (node.`val` >= max) 1 else 0
        }

        return dfs(root, root!!.`val`)
    }
}

fun main() {
    val tree = TreeNode(3)
    tree.left = TreeNode(1)
    tree.right = TreeNode(4)
    tree.left!!.left = TreeNode(3)
    tree.right!!.left = TreeNode(1)
    tree.right!!.right = TreeNode(5)
    val s = Solution()
    s.goodNodes(tree).also(::println)
}