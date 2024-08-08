package `230_Kth_Smallest_Element_in_a_BST`

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class Solution {

    val list = mutableListOf<Int>()

    fun dfs(node: TreeNode?, k: Int) {
        if (node == null)
            return

        if (list.size >= k)
            return

        dfs(node.left, k)
        list.add(node.`val`)
        dfs(node.right, k)
    }

    fun kthSmallest(root: TreeNode?, k: Int): Int {
        dfs(root, k)
        return list.get(k - 1)
    }
}
