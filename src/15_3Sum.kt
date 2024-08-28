package `15_3Sum`

class Solution {
    fun threeSum(nums: IntArray): List<List<Int>> {
        nums.sort()
        var index = 0

        val result = mutableSetOf<List<Int>>()

        while (index < nums.size && nums[index] <= 0) {
            if (index > 0 && index <= nums.lastIndex) {
                if (nums[index] == nums[index - 1]) {
                    index++
                    continue
                }
            }
            var left = index + 1
            var right = nums.lastIndex
            while (left < right) {
                val sum = nums[index] + nums[left] + nums[right]
                when {
                    sum == 0 -> {
                        result.add(listOf(nums[index], nums[left], nums[right]))
                        left++
                        right = nums.lastIndex
                    }
                    sum > 0 -> right--
                    else -> left++
                }
            }
            index++
        }

        return result.toList()
    }
}

fun main() {
    val s = Solution()
    s.threeSum(intArrayOf(0,0,0,0))
}