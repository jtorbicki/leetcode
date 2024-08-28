package `287_Find_the_Duplicate_Number`

class Solution {
    fun findDuplicate(nums: IntArray): Int {
        var slow = nums[0]
        var fast = nums[nums[0]]

        while (slow != fast) {
            slow = nums[slow]
            fast = nums[nums[fast]]
        }

        var slow2 = 0
        while (slow != slow2) {
            slow = nums[slow]
            slow2 = nums[slow2]
        }

        return slow
    }
}

fun main() {
    val s = Solution()
    s.findDuplicate(intArrayOf(1,3,4,2,2)).also { println(it) }
    s.findDuplicate(intArrayOf(3,1,3,4,2)).also { println(it) }
    s.findDuplicate(intArrayOf(3,3,3,3,3)).also { println(it) }
    s.findDuplicate(intArrayOf(2,5,9,6,9,3,8,9,7,1)).also { println(it) }
}