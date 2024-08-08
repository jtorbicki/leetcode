package `55_Jump_Game`

class Solution {
    fun canJump(nums: IntArray): Boolean {
        var goal = nums.lastIndex
        for (i in nums.lastIndex - 1 downTo 0) {
            if (i + nums[i] >= goal) {
                goal = i
            }
        }
        return goal == 0
    }
}

fun main() {
    val s = Solution()
    s.canJump(intArrayOf(3,2,1,0,4)).also { println(it) }
}