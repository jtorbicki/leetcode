package `1143_Longest_Common_Subsequence`

class Solution {
    fun longestCommonSubsequence(text1: String, text2: String): Int {
        val mem = Array(text1.length + 1) {
            IntArray(text2.length + 1) { -1 }
        }

        fun lcs(idx1: Int, idx2: Int): Int {
            val v = mem[idx1][idx2]
            if (v != -1)
                return v

            val result = when {
                idx1 == text1.length || idx2 == text2.length -> 0
                text1[idx1] == text2[idx2] -> 1 + lcs(idx1 + 1, idx2 + 1)
                else -> maxOf(lcs(idx1 + 1, idx2), lcs(idx1, idx2 + 1))
            }

            mem[idx1][idx2] = result
            return result
        }

        return lcs(0, 0)
    }
}

fun main() {
    val s = Solution()
    s.longestCommonSubsequence("AAA", "BBB").also { println(it) }
    s.longestCommonSubsequence("AAA", "AA").also { println(it) }
    s.longestCommonSubsequence("AAA", "AAA").also { println(it) }
}