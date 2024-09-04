package `105_Construct_Binary_Tree_from_Preorder_and_Inorder_Traversal`

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class Solution {

    var root: TreeNode? = null

    fun buildTree(preorder: IntArray, inorder: IntArray): TreeNode? {
        if (preorder.isEmpty())
            return null

        val node = TreeNode(preorder[0])
        val nodeIndex = inorder.indexOf(node.`val`)
        node.left = buildTree(preorder.copyOfRange(1, nodeIndex + 1), inorder.copyOfRange(0, nodeIndex))
        node.right = buildTree(preorder.copyOfRange(1 + nodeIndex, preorder.size), inorder.copyOfRange(nodeIndex + 1, inorder.size))
        return node
    }
}

fun main() {
    val s = Solution()
    s.buildTree(
        intArrayOf(3,9,20,15,7),
        intArrayOf(9,3,15,20,7)
    )
    val a = 1
}