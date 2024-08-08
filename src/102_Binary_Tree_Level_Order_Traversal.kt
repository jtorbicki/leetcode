package `102_Binary_Tree_Level_Order_Traversal`

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class Solution {

    val queue = mutableListOf<TreeNode>()
    val res = mutableListOf<List<Int>>()

    fun processQueue() {
        if (queue.isEmpty()) return
        val nodes = mutableListOf<TreeNode>()
        val values = mutableListOf<Int>()
        while (!queue.isEmpty()) {
            val node = queue.removeFirst()
            if (node.left != null) nodes.add(node.left!!)
            if (node.right != null) nodes.add(node.right!!)
            values.add(node.`val`)
        }
        res.add(values)
        queue.addAll(nodes)
        processQueue()
    }

    fun levelOrder(root: TreeNode?): List<List<Int>> {
        if (root != null) {
            queue.add(root)
            processQueue()
        }
        return res
    }
}

fun main() {
    val solution = Solution()
    val tree = TreeNode(3)
    tree.left = TreeNode(9)
    tree.right = TreeNode(20)
    tree.right!!.right = TreeNode(7)
    tree.right!!.left = TreeNode(15)
    solution.levelOrder(tree).let { println(it) }
}