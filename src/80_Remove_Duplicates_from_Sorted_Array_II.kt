package `80_Remove_Duplicates_from_Sorted_Array_II`

class Solution {
    fun removeDuplicates(nums: IntArray): Int {
        var i = 0
        var j = 0
        val set = mutableMapOf<Int, Int>()

        while (j < nums.size) {
            val count = set.getOrDefault(nums[j], 0) + 1
            if (count < 3) {
                nums[i] = nums[j]
                i++
            }
            set.put(nums[j], count)
            j++
        }
        return i
    }
}

fun main() {
    val solution = Solution()
    solution.removeDuplicates(intArrayOf(0,0,1,1,1,1,2,3,3)).also { println(it) }
}