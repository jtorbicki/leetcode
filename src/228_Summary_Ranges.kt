package `228_Summary_Ranges`

class Solution {
    fun summaryRanges(nums: IntArray): List<String> {
        val result = mutableListOf<String>()

        var i = 0

        while (i <= nums.lastIndex) {
            val start = nums[i]

            while (i < nums.lastIndex && nums[i] + 1 == nums[i + 1]) {
                i++
            }

            if (start != nums[i]) {
                result.add("${start}->${nums[i]}")
            } else {
                result.add("${start}")
            }

            i++
        }
        return result
    }
}

fun main() {
    val s = Solution()
    s.summaryRanges(intArrayOf(0,2,3,4,6,8,9)).also { println(it) }
}