package `209_Minimum_Size_Subarray_Sum`

class Solution {
    fun minSubArrayLen(target: Int, nums: IntArray): Int {
        var size: Int? = null
        var sum = nums[0]

        var left = 0
        var right = 0

        if (sum >= target) {
            return 1
        }

        while (left < nums.size) {
            when {
                sum <= target && right < nums.size - 1 -> {
                    sum += nums[++right]
                }

                sum > target -> {
                    sum -= nums[left++]
                }

                else -> break
            }
            if (sum >= target) {
                size = size?.let { minOf(it, right - left + 1) } ?: (right - left + 1)
            }
        }

        return size ?: 0
    }
}

fun main(args: Array<String>) {
    val solution = Solution()
    solution.minSubArrayLen(6, intArrayOf(10, 2, 3)).also { println(it) }
}