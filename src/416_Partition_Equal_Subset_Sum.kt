package `416_Partition_Equal_Subset_Sum`

class Solution {
    fun canPartition(nums: IntArray): Boolean {

        val total = nums.sum()

        val cache: MutableMap<String, Boolean> = mutableMapOf()

        fun bt(index: Int, sum: Int): Boolean {
            if (total - sum == sum) {
                return true
            }
            if (index == nums.size || total < sum) {
                return false
            }
            val key = "$index#$sum"
            if (cache.containsKey(key)) {
                return cache[key]!!
            }

            val value = bt(index + 1, sum + nums[index]) || bt(index + 1, sum)
            cache[key] = value
            return value
        }

        if (total % 2 != 0)
            return false

        return bt(0, 0)
    }
}

fun main() {
    val s = Solution()
    s.canPartition(intArrayOf(1, 5, 11, 5)).also { println(it) }
}