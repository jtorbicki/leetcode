package `1874_Minimize_Product_Sum_of_Two_Arrays`

class Solution {
    fun minProductSum(nums1: IntArray, nums2: IntArray): Int {
        nums1.sort()
        return nums2.sortedDescending().foldIndexed(0) { index, acc, value ->
            acc + value * nums1[index]
        }
    }
}