package `2390_Removing_Stars_From_a_String`

class Solution {
    fun removeStars(s: String): String {
        val out = mutableListOf<Char>()
        for (c in s) {
            when (c) {
                '*' -> out.removeLast()
                else -> out.add(c)
            }
        }
        return out.joinToString("")
    }
}

fun main(args: Array<String>) {
    val s = Solution().removeStars("leet**cod*e").also(::println)
}
