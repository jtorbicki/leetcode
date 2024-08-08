package `3151_Special_Array_I`

import java.util.*

class Solution {
    fun isArraySpecial(nums: IntArray): Boolean {
        val evenOdd = nums[0] % 2

        for (i in 1 until nums.size) {
            if (i % 2 == 0) {
                if (nums[i] % 2 != evenOdd) {
                    return false
                }
            } else {
                if (nums[i] % 2 == evenOdd) {
                    return false
                }
            }
        }
        return true
    }
}

fun main() {
    val solution = Solution()
    solution.isArraySpecial(intArrayOf(1, 2)).also { println(it) }
}
