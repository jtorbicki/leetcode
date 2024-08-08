package `53_Maximum_Subarray`

import kotlin.math.max

class Solution {
    fun maxSubArray(nums: IntArray): Int {
        var maxSum = nums[0]
        var sum = 0
        for (num in nums) {
            sum = max(sum + num, num)
            maxSum = max(maxSum, sum)
        }
        return maxSum
    }
}
fun main(args: Array<String>) {
    val solution = Solution()
    solution.maxSubArray(intArrayOf(-2,1,-3,4,-1,2,1,-5,4)).let(::println)
}
