package `139_Word_Break`

class Solution {
    fun wordBreak(s: String, wordDict: List<String>): Boolean {
        val dp = BooleanArray(s.length + 1)
        dp[dp.lastIndex] = true
        for (i in s.lastIndex downTo 0) {
            for (word in wordDict) {
                if (i + word.length < dp.size) {
                    if (s.substring(i, i + word.length) == word) {
                        if (dp[i + word.length]) {
                            dp[i] = true
                        }
                    }
                }
            }
        }
        return dp[0]
    }
}

fun main() {
    val s = Solution()
    s.wordBreak("leetcode", listOf("leet","code")).also { println(it) }
}