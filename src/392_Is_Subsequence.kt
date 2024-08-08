package `392_Is_Subsequence`

class Solution {
    fun isSubsequence(s: String, t: String): Boolean {
        var start = 0
        for (c in s.toCharArray()) {
            start = t.indexOf(c, start)
            if (start == -1) return false
            start++
        }
        return true
    }
}

fun main() {
    val solution = Solution()
    solution.isSubsequence("axc", "ahbgdc")
}