package `100_Same_Tree`

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class Solution {
    fun isSameTree(p: TreeNode?, q: TreeNode?): Boolean {
        return when {
            p == q -> true
            p?.`val` != q?.`val` -> false
            p != null && p.left == null && q != null && q.left == null && p.right == null && q.right == null-> true
            else -> isSameTree(p?.left, q?.left) && isSameTree(p?.right, q?.right)
        }
    }
}

fun main() {
    val s = Solution()
    val p = TreeNode(1)
    val q = TreeNode(1)
    q.right = TreeNode(2)
    s.isSameTree(p, q).also { println(it) }
}