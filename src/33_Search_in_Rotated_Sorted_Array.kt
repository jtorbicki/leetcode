package `33_Search_in_Rotated_Sorted_Array`

class Solution {
    fun search(nums: IntArray, target: Int): Int {
        var left = 0
        var right = nums.lastIndex

        while (left <= right) {
            val middle = left + (right - left) / 2
            if (nums[middle] == target) {
                return middle
            }

            if (nums[left] <= nums[middle]) {
                if (target > nums[middle] || target < nums[left]) {
                    left = middle + 1
                } else {
                    right = middle - 1
                }
            } else {
                if (target < nums[middle] || target > nums[right]) {
                    right = middle - 1
                } else {
                    left = middle + 1
                }
            }
        }
        return -1
    }
}

// 11, 12, 13, 14, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 | 15