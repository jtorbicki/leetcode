package `3_Longest_Substring_Without_Repeating_Characters`

import kotlin.math.max

class Solution {
    fun lengthOfLongestSubstring(s: String): Int {
        val set = mutableSetOf<Char>()
        var max = 0
        var left = 0
        val size = s.length
        for (right in 0 until size) {
            while (set.contains(s[right])) {
                set.remove(s[left])
                left++
            }
            set.add(s[right])
            max = max(max, right - left + 1)
        }
        return max
    }
}

fun main(args: Array<String>) {
    val solution = Solution()
    println(solution.lengthOfLongestSubstring("pwwkew"))
}