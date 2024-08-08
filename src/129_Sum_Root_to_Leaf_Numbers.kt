package `129_Sum_Root_to_Leaf_Numbers`

import java.util.*

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class Solution {
    val numbers = mutableListOf<Int>()
    val digits = LinkedList<Int>()

    fun process(node: TreeNode?) {
        if (node == null)
            return

        digits.add(node.`val`)

        if (node.left == null && node.right == null) {
            val computed = digits.joinToString("").toInt()
            numbers.add(computed)
        } else {
            process(node.left)
            process(node.right)
        }

        digits.removeLast()
    }

    fun sumNumbers(root: TreeNode?): Int {
        process(root)
        return numbers.sum()
    }
}

fun main() {
    val s = Solution()
    val tree = TreeNode(4)
    tree.left = TreeNode(9)
    tree.right = TreeNode(0)
    tree.left!!.left = TreeNode(5)
    tree.left!!.right = TreeNode(1)
    s.sumNumbers(tree).also { println(it) }
}