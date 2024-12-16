package `424_Longest_Repeating_Character_Replacement`

class Solution {
    fun characterReplacement(s: String, k: Int): Int {
        val count = IntArray(26) { 0 }
        var maxCount = 0
        var start = 0
        var maxLength = 0

        for (end in s.indices) {
            count[s[end] - 'A']++
            maxCount = maxOf(maxCount, count[s[end] - 'A'])

            while (end - start + 1 - maxCount > k) {
                count[s[start] - 'A']--
                start++
            }

            maxLength = maxOf(maxLength, end - start + 1)
        }

        return maxLength
    }
}

fun main() {
    val s = Solution()
//    s.characterReplacement("ABAB", 2).also { println(it) }
    s.characterReplacement("AABABBA", 1).also { println(it) }
}