package `268_Missing_Number`

class Solution {
    fun missingNumber(nums: IntArray): Int {
        var total = 0
        var inArray = 0
        for ((index, num) in nums.withIndex()) {
            total += (index + 1)
            inArray += num
        }
        return inArray - total
    }
}