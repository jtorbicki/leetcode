package `189_Rotate_Array`

class Solution {
    fun rotate(nums: IntArray, k: Int): Unit {
        if (k != 0) {
            val index = k % nums.size
            nums.reverse()
            nums.reverse(0, index)
            nums.reverse(index, nums.size)
        }
    }
}

fun main(args: Array<String>) {
    val solution = Solution()
    val a = intArrayOf(1,2,3,4,5,6,7)
    solution.rotate(a, 3)
    println(a.contentToString())
}