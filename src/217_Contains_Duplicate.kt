package `217_Contains_Duplicate`

class Solution {
    fun containsDuplicate(nums: IntArray): Boolean {
        val set = mutableSetOf<Int>()

        for (n in nums) {
            when (n in set) {
                true -> return true
                false -> set.add(n)
            }
        }

        return false
    }
}
