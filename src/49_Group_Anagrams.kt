package `49_Group_Anagrams`

class Solution {
    fun groupAnagrams(strs: Array<String>): List<List<String>> {
        val map = mutableMapOf<String, MutableList<String>>()

        for (s in strs) {
            val sorted = s.toCharArray().sorted().joinToString("")
            val list = map.getOrDefault(sorted, mutableListOf())
            map[sorted] = list
            list.add(s)
        }

        return map.values.toList()
    }
}

fun main() {
    val s = Solution()
    s.groupAnagrams(arrayOf("eat","tea","tan","ate","nat","bat"))
}
