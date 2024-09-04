package `128_Longest_Consecutive_Sequence`

class Solution {
    fun longestConsecutive(nums: IntArray): Int {
        val set = nums.toSet()
        val sequences = nums.filter { !set.contains(it - 1) }.toSet()
        var max = 0

        for (s in sequences) {
            var counter = 1
            while ((s + counter) in set) {
                counter += 1
            }
            max = maxOf(max, counter)
        }

        return max
    }
}
