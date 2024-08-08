package `151_Reverse_Words_in_a_String`

class Solution {
    fun reverseWords(s: String): String {
        return s.trim().split("\\s+".toRegex()).reversed().joinToString(" ")
    }
}

fun main(args: Array<String>) {
    val s = "a good   example"
    Solution().reverseWords(s).also { println(it) }
}