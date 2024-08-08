package `238_Product_of_Array_Except_Self`

class Solution {
    fun productExceptSelf(nums: IntArray): IntArray {
        val left = IntArray(nums.size) { 1 }
        val right = IntArray(nums.size) { 1 }
        val product = IntArray(nums.size)

        var p = 1
        for (i in 1..nums.lastIndex) {
            p *= nums[i-1]
            left[i] = p
        }

        p = 1
        for (i in nums.lastIndex - 1 downTo 0) {
            p *= nums[i+1]
            right[i] = p
        }

        for (i in 0..nums.lastIndex) {
            product[i] = left[i] * right[i]
        }

        return product
    }
}

fun main() {
    val s = Solution()
    s.productExceptSelf(intArrayOf(-1,1,0,-3,3)).also { println(it.contentToString()) }
}