package `179_Largest_Number`

class Solution {
    fun largestNumber(nums: IntArray): String {
        val numStrs = nums.map { it.toString() }
        val sortedNumStrs = numStrs.sortedWith { a, b ->
            (b + a).compareTo(a + b)
        }
        val result = sortedNumStrs.joinToString("")
        return if (result[0] == '0') "0" else result
    }
}

fun main() {
    val s = Solution()
    s.largestNumber(intArrayOf(3, 30, 34, 5, 9)).also { println(it) }
    //s.largestNumber(intArrayOf(1,2,3,4,5,6)).also { println(it) }
}
