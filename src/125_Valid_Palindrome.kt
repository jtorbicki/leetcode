package `125_Valid_Palindrome`

class Solution {
    private fun isAlpha(c: Char): Boolean = c.isLetterOrDigit()

    fun isPalindrome(s: String): Boolean {
        var i = 0
        var j = s.length - 1

        while (i < j) {
            if (!isAlpha(s[i])) {
                i++
                continue
            }
            if (!isAlpha(s[j])) {
                j--
                continue
            }
            val c1 = s[i].lowercase()
            val c2 = s[j].lowercase()
            if (c1 != c2)
                return false
            i++
            j--
        }
        return true
    }
}

fun main() {
    val solution = Solution()
    println(Solution().isPalindrome("0P"))
}
