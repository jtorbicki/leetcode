package `572_Subtree_of_Another_Tree`

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class Solution {
    fun isSame(node1: TreeNode?, node2: TreeNode?): Boolean {
        return when {
            node1 == null && node2 == null -> true
            node1 == null || node2 == null || node1.`val` != node2.`val` -> false
            else -> isSame(node1.left, node2.left) && isSame(node1.right, node2.right)
        }
    }

    fun isSubtree(root: TreeNode?, subRoot: TreeNode?): Boolean {
        return when {
            root == null && subRoot == null -> true
            root == null || subRoot == null -> false
            root.`val` != subRoot.`val` -> isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot)
            else -> isSame(root, subRoot) || isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot)
        }
    }
}

fun main() {
    val s = Solution()
    val tree = TreeNode(3)
    tree.left = TreeNode(4)
    tree.right = TreeNode(5)
    tree.left!!.left = TreeNode(1)
    tree.left!!.right = TreeNode(2)
    val sub = TreeNode(4)
    sub.left = TreeNode(1)
    sub.right = TreeNode(2)
    s.isSubtree(tree, sub).also { println(it) }
}