package `1028_Recover_a_Tree_From_Preorder_Traversal`

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class Solution {
    fun recoverFromPreorder(traversal: String): TreeNode? {
        var index = 0

        fun readValue(): Int {
            var result = ""
            while (index < traversal.length && traversal[index] != '-') {
                result += traversal[index]
                index += 1
            }
            return result.toInt()
        }

        fun readDepth(): Int {
            var depth = 0
            while (index < traversal.length && traversal[index] == '-') {
                depth += 1
                index += 1
            }
            return depth
        }

        val root = TreeNode(readValue())

        while (index < traversal.length) {
            val depth = readDepth()
            val value = readValue()
            var node: TreeNode = root
            repeat(depth - 1) {
                node = when {
                    node.right != null -> node.right!!
                    else -> node.left!!
                }
            }
            if (node.left == null) {
                node.left = TreeNode(value)
            } else {
                node.right = TreeNode(value)
            }
        }
        return root
    }
}

fun main() {
    val s = Solution()
    s.recoverFromPreorder("1-2--3---5")
}