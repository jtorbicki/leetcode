package `1679_Max_Number_of_K-Sum_Pairs`

class Solution {
    fun maxOperations(nums: IntArray, k: Int): Int {
        val map = mutableMapOf<Int,Int>()
        var sum = 0

        for (n in nums) {
            val diff = k - n
            if (diff >= 0) {
                val exists = map.containsKey(diff)
                if (exists) {
                    map.compute(diff) { _, v -> if (v!! == 1) null else v - 1 }
                    sum++
                } else {
                    map.compute(n) { _, v -> if (v == null) 1 else v + 1 }
                }
            }
        }

        return sum
    }
}

fun main(args: Array<String>) {
    val solution = Solution()
    solution.maxOperations(intArrayOf(2,5,4,4,1,3,4,4,1,4,4,1,2,1,2,2,3,2,4,2), 3).let(::println)
}