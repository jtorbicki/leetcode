package `5_Longest_Palindromic_Substring`

class Solution {

    fun isPalindrome(s: String, start: Int, end: Int): Boolean {
        var left = start
        var right = end
        while (left <= right) {
            if (s[left] != s[right])
                return false
            left++
            right--
        }
        return true
    }

    fun longestPalindrome(s: String): String {
        var max = 0
        var palindrome = s[0].toString()
        outer@for (index in s.indices) {
            var step = 0
            do {
                val start = index - step
                if (start < 0) {
                    continue@outer
                }
                var end = index + step
                if (end >= s.length) {
                    continue@outer
                }
                var result = isPalindrome(s, start, end)
                if (result) {
                    if (end + 1 - start > max) {
                        max = end + 1 - start
                        palindrome = s.substring(start, end + 1)
                    }
                }
                end = index + step + 1
                if (end >= s.length) {
                    continue@outer
                }
                val result2 = isPalindrome(s, start, end)
                if (result2) {
                    if (end + 1 - start > max) {
                        max = end + 1 - start
                        palindrome = s.substring(start, end + 1)
                    }
                }
                step++
            } while (result || result2)

        }
        return palindrome
    }
}

fun main() {
    val solution = Solution()
    solution.longestPalindrome("ccc").also { println(it) }
}