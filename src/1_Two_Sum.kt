package `1_Two_Sum`

import kotlin.collections.HashMap

class Solution {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val savedNums = HashMap<Int, Int>(nums.size)
        for ((index, value) in nums.withIndex()) {
            val num = target - value
            if (num in savedNums.keys) {
                return intArrayOf(savedNums[num]!!, index)
            } else {
                savedNums[value] = index
            }
        }
        return intArrayOf()
    }
}

fun main() {
    val solution = Solution()
    println(solution.twoSum(intArrayOf(2, 7, 11, 15), 9).contentToString())
}