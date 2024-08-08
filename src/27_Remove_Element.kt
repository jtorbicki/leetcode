package `27_Remove_Element`

class Solution {
    fun removeElement(nums: IntArray, `val`: Int): Int {
        var left = 0
        var right = nums.size - 1
        var count = 0

        while (left <= right) {
            if (nums[left] != `val`) {
                left++
                count++
            } else {
                val temp = nums[left]
                nums[left] = nums[right]
                nums[right] = temp
                right--
            }
        }

        return count
    }
}

fun main() {
    val solution = Solution()
    val a = intArrayOf(1, 2, 3, 4, 5)
    println(solution.removeElement(a, 3))
    println(a.contentToString())
}