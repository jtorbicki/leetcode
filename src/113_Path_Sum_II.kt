package `113_Path_Sum_II`

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class Solution {
    fun pathSum(root: TreeNode?, targetSum: Int): List<List<Int>> {

        val result = mutableListOf<List<Int>>()
        val nodes = mutableListOf<Int>()

        fun dfs(node: TreeNode?, sum: Int) {
            if (node == null)
                return

            val s = sum + node.`val`

            nodes.add(node.`val`)

            if (node.left == null && node.right == null) {
                if (s == targetSum) {
                    result.add(ArrayList(nodes))
                }
            } else {
                dfs(node.left, s)
                dfs(node.right, s)
            }

            nodes.removeLast()
        }

        dfs(root, 0)

        return result
    }
}