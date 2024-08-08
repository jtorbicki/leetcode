package `34_Find_First_and_Last_Position_of_Element_in_Sorted_Array`

class Solution {
    fun searchRange(nums: IntArray, target: Int): IntArray {
        val index = nums.binarySearch(target)
        if (index < 0) {
            return intArrayOf(-1, -1)
        }

        var left = index
        var right = index

        while (true) {
            val newIndex = nums.binarySearch(target, right + 1)
            if (newIndex < 0) {
                break
            }
            right = newIndex
        }

        while (true) {
            val newIndex = nums.binarySearch(target, 0, left)
            if (newIndex < 0) {
                break
            }
            left = newIndex
        }

        return intArrayOf(left, right)
    }
}

fun main() {
    val s = Solution()
    s.searchRange(intArrayOf(5,7,7,8,8,10), 8).also { println(it.contentToString()) }
}