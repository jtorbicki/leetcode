package `1063_Number_of_Valid_Subarrays`

class Solution {
    fun validSubarrays(nums: IntArray): Int {

        fun bt(leftMostIndex: Int, index: Int): Int {
            if (index == nums.size)
                return 0

            if (nums[index] < nums[leftMostIndex])
                return 0

            return 1 + bt(leftMostIndex, index + 1)
        }

        var count = 0
        for (i in 0..nums.lastIndex) {
            count += bt(i, i)
        }
        return count
    }
}

fun main() {
    val s = Solution()
    s.validSubarrays(intArrayOf(1,4,2,5,3)).also { println(it) }
}