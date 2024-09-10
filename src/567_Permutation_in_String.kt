package `567_Permutation_in_String`

class Solution {
    fun checkInclusion(s1: String, s2: String): Boolean {
        if (s2.length < s1.length)
            return false

        val arrS1 = IntArray(26)
        val arrS2 = IntArray(26)

        for (c in s1) {
            arrS1[c.minus('a')] += 1
        }

        val range = 0..< s1.lastIndex
        for (i in range) {
            arrS2[s2[i].minus('a')] += 1
        }

        var left = 0

        while (left + s1.length <= s2.length) {
            arrS2[s2[left + s1.lastIndex].minus('a')] += 1
            if (arrS2 contentEquals arrS1) {
                return true
            }
            arrS2[s2[left].minus('a')] -= 1
            left += 1
        }
        return false
    }
}

fun main() {
    val s = Solution()
    s.checkInclusion("ab", "eidbaooo").also { println(it) }
}