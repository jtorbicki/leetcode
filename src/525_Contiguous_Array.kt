package `525_Contiguous_Array`

class Solution {
    fun findMaxLength(nums: IntArray): Int {
        var ones = 0
        var zeros = 0

        val map = mutableMapOf<Int, Int>()

        var max = 0
        for ((index, n) in nums.withIndex()) {
            when (n) {
                0 -> zeros += 1
                1 -> ones += 1
            }
            val diff = ones - zeros
            if (diff == 0) {
                max = ones + zeros
            } else {
                if (map.containsKey(diff)) {
                    max = maxOf(max, index - map[diff]!!)
                } else {
                    map[diff] = index
                }
            }
        }
        return max
    }
}

fun main() {
    val s = Solution()
    s.findMaxLength(intArrayOf(0,1)).also { println(it) }
}