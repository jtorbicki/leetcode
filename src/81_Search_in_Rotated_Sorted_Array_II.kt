package `81_Search_in_Rotated_Sorted_Array_II`

class Solution {
    fun search(nums: IntArray, target: Int): Boolean {
        var left = 0
        var right = nums.lastIndex

        if (nums.isEmpty())
            return false

        if (nums.size == 1)
            return nums[0] == target

        while (left <= right) {
            val middle = left + (right - left) / 2
            if (middle > 0 && nums[middle] < nums[middle - 1]) {
                left = middle
                break
            } else if (nums[middle] > nums.last()) {
                left = middle + 1
            } else {
                right = middle - 1
            }
        }

        val pivot = maxOf(left - 1, 0)
        if (nums[pivot] == target)
            return true

        if (nums.first() >= target && nums[pivot] <= target) {
            return nums.binarySearch(target, 0, pivot) >= 0
        } else {
            return nums.binarySearch(target, pivot + 1, nums.size) >= 0
        }
    }
}

fun main() {
    val s = Solution()
    s.search(intArrayOf(1,1,1,1,1,1,1,1,1,1,1,1,1,2,1,1,1,1,1), 2).also { println(it) }
}