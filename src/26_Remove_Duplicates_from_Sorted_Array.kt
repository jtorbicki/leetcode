package `26_Remove_Duplicates_from_Sorted_Array`

class Solution {
    fun removeDuplicates(nums: IntArray): Int {
        var i = 0
        var j = 0
        val set = mutableSetOf<Int>()

        while (j < nums.size) {
            if (nums[j] !in set) {
                set += nums[j]
                nums[i] = nums[j]
                i++
            }
            j++
        }
        return i
    }
}

fun main() {
    val solution = Solution()
    solution.removeDuplicates(intArrayOf(1, 1, 2)).also { println(it) }
}