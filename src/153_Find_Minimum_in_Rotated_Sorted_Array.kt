package `153_Find_Minimum_in_Rotated_Sorted_Array`

class Solution {
    fun findMin(nums: IntArray): Int {
        var left = 0
        var right = nums.lastIndex
        var min = nums[0]

        while (left <= right) {
            val middle = left + (right - left) / 2
            val value = nums[middle]
            min = minOf(min, value)
            if (value >= nums[left] && value >= nums[right]) {
                left = middle + 1
            } else {
                right = middle - 1
            }
        }

        return min
    }
}

fun main() {
    val s = Solution()
    s.findMin(intArrayOf(4,5,6,7,0,1,2)).also { println(it) }
}