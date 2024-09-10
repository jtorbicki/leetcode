package `33_Search_in_Rotated_Sorted_Array`

//class Solution {
//    fun search(nums: IntArray, target: Int): Int {
//        var left = 0
//        var right = nums.lastIndex
//
//        while (left <= right) {
//            val middle = left + (right - left) / 2
//            if (nums[middle] == target) {
//                return middle
//            }
//
//            if (nums[left] <= nums[middle]) {
//                if (target > nums[middle] || target < nums[left]) {
//                    left = middle + 1
//                } else {
//                    right = middle - 1
//                }
//            } else {
//                if (target < nums[middle] || target > nums[right]) {
//                    right = middle - 1
//                } else {
//                    left = middle + 1
//                }
//            }
//        }
//        return -1
//    }
//}

class Solution {
    fun search(nums: IntArray, target: Int): Int {
        var lo = 0
        var hi = nums.size - 1
        val n = nums.size - 1

        while(lo <= hi) {
            val mid = lo + (hi - lo)/2
            if(nums[mid] > nums[n]) {
                lo = mid + 1
            } else {
                hi = mid -1
            }
        }

        val ans =  binarySearch(nums, 0, lo - 1, target)

        if(ans != -1) {
            return ans
        }

        return binarySearch(nums, lo, n, target)
    }

    fun binarySearch(nums:IntArray, low:Int, high:Int, target:Int):Int{
        var lo = low
        var hi = high

        while(lo <= hi) {
            val mid = lo + (hi - lo)/2

            if(target > nums[mid]) {
                lo = mid + 1
            } else if(target < nums[mid]) {
                hi = mid - 1
            } else {
                return mid
            }
        }

        return -1
    }
}

fun main() {
    val s = Solution()
    s.search(intArrayOf(7, 8, 9, 10, 11, 12, 13, 14, 1, 2, 3, 4, 5, 6), 11)
}