package `75_Sort_Colors`

class Solution {
    fun sortColors(nums: IntArray): Unit {
        if (nums.size < 2) return
        var left = 0
        var right = nums.lastIndex
        var index = 0

        while (index <= right) {
            if (nums[index] == 0) {
                val temp = nums[index]
                nums[index] = nums[left]
                nums[left] = temp
                left++
            }
            if (nums[index] == 2) {
                val temp = nums[index]
                nums[index] = nums[right]
                nums[right] = temp
                right--
                index--
            }
            index++
        }
    }
}

fun main(args: Array<String>) {
    val solution = Solution()
    solution.sortColors(intArrayOf(0,1,2,1,1,1)).let { println(it) }
}