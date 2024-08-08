package `58_Length_of_Last_Word`

class Solution {
    fun lengthOfLastWord(s: String): Int {
        var result = 0
        var lastIndex = s.lastIndex
        for (i in lastIndex downTo 0) {
            lastIndex = i
            if (!s[i].isWhitespace()) {
                break
            }
        }
        for (i in lastIndex downTo 0) {
            if (s[i].isWhitespace()) {
                break
            }
            result = i
        }
        return lastIndex - result + 1
    }
}

fun main() {
    val s = Solution()
    s.lengthOfLastWord("   fly me   to   the moon  ").also { println(it) }
}