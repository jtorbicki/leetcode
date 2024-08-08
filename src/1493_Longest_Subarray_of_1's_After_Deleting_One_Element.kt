package `1493_Longest_Subarray_of_1's_After_Deleting_One_Element`

class Solution {
    fun longestSubarray(nums: IntArray): Int {
        var max = 0
        var left = 0
        var zeros = 0

        for (right in nums.indices) {
            if (nums[right] == 0) {
                zeros++
            }

            while (zeros > 1) {
                if (nums[left] == 0)
                    zeros--
                left++
            }

            max = maxOf(max, right - left)
        }

        return max
    }
}

fun main(args: Array<String>) {
    val solution = Solution()
    solution.longestSubarray(intArrayOf(0,1,1,1,0,1,1,0,1)).also(::println)
}