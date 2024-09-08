package `16_3Sum_Closest`

import kotlin.math.abs

class Solution {
    fun threeSumClosest(nums: IntArray, target: Int): Int {
        nums.sort()

        var result = Int.MAX_VALUE
        var min = Int.MAX_VALUE

        var index = 0
        outer@while (index <= nums.lastIndex - 2) {
            val value = target - nums[index]
            var left = index + 1
            var right = nums.lastIndex

            while (left < right) {
                val sum = nums[left] + nums[right]
                when {
                    sum < value -> left += 1
                    sum > value -> right -= 1
                    else -> {
                        result = target
                        break@outer
                    }
                }
                if (abs(sum + nums[index] - target) < min) {
                    min = abs(sum + nums[index] - target)
                    result = sum + nums[index]
                }
            }
            index += 1
        }

        return result
    }
}

fun main() {
    val s = Solution()
    s.threeSumClosest(intArrayOf(-1, 2, 1, -4), 1).also { println(it) }
}