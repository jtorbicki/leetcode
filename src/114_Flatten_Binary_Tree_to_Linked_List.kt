package `114_Flatten_Binary_Tree_to_Linked_List`

import java.util.*

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class Solution {
    var nodes = LinkedList<TreeNode>()

    fun process(root: TreeNode?) {
        if (root == null)
            return

        nodes.add(root)
        process(root.left)
        process(root.right)
    }

    fun flatten(root: TreeNode?): Unit {
        if (root == null)
            return

        process(root)
        var node = nodes.removeFirst()
        while (nodes.isNotEmpty()) {
            val next = nodes.removeFirst()
            node?.right = next
            node?.left = null
            node = next
        }
    }
}

fun main() {
    val s = Solution()
    val tree = TreeNode(0)
    s.flatten(tree)
    val a = 1
}