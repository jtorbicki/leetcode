package `108_Convert_Sorted_Array_to_Binary_Search_Tree`

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class Solution {

    fun sortedArrayToBST(nums: IntArray): TreeNode? {

        fun convert(left: Int, right: Int): TreeNode? {
            if (left > right) {
                return null
            } else {
                val middle = left + (right - left) / 2
                val node = TreeNode(nums[middle])
                node.left = convert(left, middle - 1)
                node.right = convert(middle + 1, right)
                return node
            }
        }

        return convert(0, nums.lastIndex)
    }
}

fun main() {
    val s = Solution()
    val a = s.sortedArrayToBST(intArrayOf(1, 2, 3, 4, 5, 6))
    val b = 1
}