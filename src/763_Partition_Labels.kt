package `763_Partition_Labels`

class Solution {
    fun partitionLabels(s: String): List<Int> {
        val map = IntArray(26)
        for ((index, c) in s.withIndex()) {
            map[c - 'a'] = index
        }

        val result = mutableListOf<Int>()
        var index = 0
        var left = -1
        var right = 0
        while (index < s.length) {
            val c = s[index]
            right = maxOf(right, map[c - 'a'])
            if (index == right) {
                result.add(right - left)
                left = index
            }

            index += 1
        }

        return result
    }
}

fun main() {
    val s = Solution()
    s.partitionLabels("ababcbacadefegdehijhklij").also { println(it) }
}