package `1657_Determine_if_Two_Strings_Are_Close`

class Solution {
    fun closeStrings(word1: String, word2: String): Boolean {
        if (word1.length != word2.length) return false

        val map1 = mutableMapOf<Char, Int>()
        val map2 = mutableMapOf<Char, Int>()

        for (c in word1) {
            map1[c] = (map1[c] ?: 0) + 1
        }
        for (c in word2) {
            map2[c] = (map2[c] ?: 0) + 1
        }

        val values1 = map1.values.sorted()
        val values2 = map2.values.sorted()

        return values1 == values2 && map1.keys == map2.keys
    }
}

fun main(args: Array<String>) {
    val solution = Solution()
    solution.closeStrings("cabbba", "abbccc").also(::println)
}