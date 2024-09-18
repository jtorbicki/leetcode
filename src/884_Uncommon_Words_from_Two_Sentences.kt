package `884_Uncommon_Words_from_Two_Sentences`

class Solution {
    fun uncommonFromSentences(s1: String, s2: String): Array<String> {
        return "$s1 $s2".split(" ").groupingBy { it }.eachCount().filterValues { it == 1 }.keys.toTypedArray()
    }
}

fun main() {
    val s = Solution()
    s.uncommonFromSentences("this apple is sweet", "this apple is sour")
}