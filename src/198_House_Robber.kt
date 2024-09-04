package `198_House_Robber`

//class Solution {
//    fun rob(nums: IntArray): Int {
//        var rob1 = 0
//        var rob2 = 0
//
//        for (n in nums) {
//            val sum = maxOf(n + rob1, rob2)
//            rob1 = rob2
//            rob2 = sum
//        }
//
//        return rob2
//    }
//}

class Solution {
    fun rob(nums: IntArray): Int {

        val arr = IntArray(nums.size + 2)
        nums.copyInto(arr, 2)

        var max = arr[2]
        for (i in 3..arr.lastIndex) {
            arr[i] = maxOf(arr[i - 2], arr[i - 3]) + arr[i]
            max = maxOf(max, arr[i])
        }

        return max
    }
}


fun main() {
    val s = Solution()
    s.rob(intArrayOf(0)).also { println(it) }
}