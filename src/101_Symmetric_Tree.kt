package `101_Symmetric_Tree`

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class Solution {
    private var queue: MutableList<TreeNode?> = ArrayList()

    fun isSymmetric(root: TreeNode?): Boolean {
        if (root == null)
            return false

        queue.add(root)

        while (queue.isNotEmpty()) {
            var left = 0
            var right = queue.lastIndex

            while (left <= right) {
                val leftNode = queue[left]
                val rightNode = queue[right]

                if (leftNode?.`val` != rightNode?.`val`)
                    return false

                left++
                right--
            }

            queue = queue.filterNotNull().flatMap { listOf(it.left, it.right) }.toMutableList()
        }

        return true
    }
}

fun main() {
    val s = Solution()
    val tree = TreeNode(1)
    tree.left = TreeNode(2)
//    tree.left!!.right = TreeNode(3)
    tree.right = TreeNode(2)
//    tree.right!!.right = TreeNode(3)
    s.isSymmetric(tree).also { println(it) }

    println((1 + 2 + 3 + 4) xor (1 + 2 + 4))
}