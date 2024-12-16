package `167_Two_Sum_II-Input_Array_Is_Sorted`

class Solution {
    fun twoSum(numbers: IntArray, target: Int): IntArray {
        var l = 0
        var r = numbers.lastIndex

        while (l < r) {
            val sum = numbers[l] + numbers[r]
            when {
                sum == target -> return intArrayOf(l + 1, r + 1)
                sum < target -> l += 1
                else -> r -= 1
            }
        }
        return intArrayOf()
    }
}
