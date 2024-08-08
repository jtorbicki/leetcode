package `283_Move_Zeroes`

class Solution {
    fun moveZeroes(nums: IntArray): Unit {

        fun swap(l: Int, r: Int) {
            val temp = nums[l]
            nums[l] = nums[r]
            nums[r] = temp
        }

        if (nums.size < 2) {
            return
        }

        var l = 0
        var r = 0

        while (l <= nums.lastIndex) {
            if (nums[l] != 0) {
                swap(l, r)
                r++
            }
            l++
        }
    }
}

fun main(args: Array<String>) {
    val solution = Solution()
    val array = intArrayOf(4,2,4,0,0,3,0,5,1,0)
    solution.moveZeroes(array).also { println(array.contentToString()) }
}