package `198_House_Robber`

class Solution {
    fun rob(nums: IntArray): Int {
        var rob1 = 0
        var rob2 = 0

        for (i in nums) {
            val t = maxOf(i + rob1, rob2)
            rob1 = rob2
            rob2 = t
        }

        return rob2
    }
}
