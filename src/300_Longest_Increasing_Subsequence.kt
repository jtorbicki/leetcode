package `300_Longest_Increasing_Subsequence`

//class Solution {
//    fun lengthOfLIS(nums: IntArray): Int {
//
//        val cache = mutableMapOf<Int, Int>()
//
//        fun bt(index: Int, last: Int): Int {
//            if (cache.containsKey(index)) {
//                return cache[index]!!
//            }
//
//            if (index == nums.lastIndex) {
//                return 1
//            } else {
//                var max = 1
//                for (i in index+1..nums.lastIndex) {
//                    val value = nums[i]
//                    if (value > last) {
//                        max = maxOf(max, bt(i, value) + 1)
//                    }
//                }
//                cache[index] = max
//                return max
//            }
//        }
//
//        var max = 0
//        for (i in 0..nums.lastIndex) {
//            max = maxOf(max, bt(i, nums[i]))
//        }
//        return max
//    }
//}

class Solution {
    fun lengthOfLIS(nums: IntArray): Int {
        val dp = IntArray(nums.size) { 1 }

        for (i in nums.lastIndex - 1 downTo 0) {
            for (j in i + 1..nums.lastIndex) {
                if (nums[i] < nums[j])
                    dp[i] = maxOf(dp[i], dp[j] + 1)
            }
        }

        return dp.max()
    }
}


fun main() {
    val s = Solution()
    s.lengthOfLIS(intArrayOf(10,9,2,5,3,7,101,18)).also { println(it) }
}