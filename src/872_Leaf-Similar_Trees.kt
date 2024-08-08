package `872_Leaf-Similar_Trees`

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class Solution {
    val list1 = mutableListOf<Int>()
    val list2 = mutableListOf<Int>()

    fun leafSimilar(root1: TreeNode?, root2: TreeNode?): Boolean {

        fun dfs(node: TreeNode?, list: MutableList<Int>) {
            if (node == null) return
            if (node.left == null && node.right == null) {
                list.add(node.`val`)
            } else {
                dfs(node.left, list)
                dfs(node.right, list)
            }
        }

        dfs(root1, list1)
        dfs(root2, list2)

        return list1 == list2
    }
}

fun main() {
    val s = Solution()
    val root = TreeNode(5)
    root.left = TreeNode(1)
    root.right = TreeNode(6)
    s.leafSimilar(root, root).also(::println)
}