package `560_Subarray_Sum_Equals_K`

class Solution {
    fun subarraySum(nums: IntArray, k: Int): Int {
        var result = 0
        val map = mutableMapOf<Int, Int>()
        map[0] = 1
        var sum = 0

        for (n in nums) {
            sum += n
            val diff = sum - k
            if (map.containsKey(diff)) {
                result += map[diff]!!
            }
            map[sum] = map.getOrDefault(sum,0) + 1
        }

        return result
    }
}

fun main() {
    val s = Solution()
    s.subarraySum(intArrayOf(1, 1, 1), 2).also { println(it) }
}