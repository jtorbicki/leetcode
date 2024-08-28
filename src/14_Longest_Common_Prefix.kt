package `14_Longest_Common_Prefix`

class Solution {
    fun longestCommonPrefix(strs: Array<String>): String {
        if (strs.isEmpty())
            return ""

        var index = -1
        val size = strs[0].lastIndex

        outer@for (i in 0.. size) {
            val commonChar = strs[0][i]

            for (s in strs) {
                if (i >= s.length || s[i] != commonChar)
                    break@outer
            }
            index = i
        }

        return strs[0].substring(0, index + 1)
    }
}

fun main() {
    val s = Solution()
    s.longestCommonPrefix(
        arrayOf("flower","flow","flight")
    ).also { println(it) }
}
