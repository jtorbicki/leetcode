package `136_Single_Number`

class Solution {
    fun singleNumber(nums: IntArray): Int {
        return nums.fold(0) {acc, value -> acc xor value }
    }
}