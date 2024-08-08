package `1004_Max_Consecutive_Ones_III`

class Solution {
    fun longestOnes(nums: IntArray, k: Int): Int {
        var max = 0
        var zeros = 0
        var l = 0
        var r = 0

        while (r <= nums.lastIndex) {
            if (nums[r] == 0) {
                zeros++
            }

            while (zeros > k) {
                if (nums[l] == 0) {
                    zeros--
                }
                l++
            }

            max = maxOf(max, r - l + 1)
            r++
        }

        return max
    }
}

fun main() {
    val solution = Solution()
    solution.longestOnes(intArrayOf(0,0,1,1,1,0,0), 0).also { println(it) }
}