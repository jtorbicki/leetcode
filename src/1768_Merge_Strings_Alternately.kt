package `1768_Merge_Strings_Alternately`

class Solution {
    fun mergeAlternately(word1: String, word2: String): String {
        val rest = when {
            word1.length == word2.length -> ""
            word2.length > word1.length -> word2.substring(word1.length)
            else -> word1.substring(word2.length)
        }
        return word1.zip(word2).map { (a, b) -> "$a$b" }.joinToString("", postfix = rest)
    }
}