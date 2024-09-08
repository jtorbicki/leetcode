package `271_Encode_and_Decode_Strings`

class Solution {
    fun encode(strs: List<String>): String {
        return strs.joinToString("$#$")
    }

    fun decode(str: String): List<String> {
        return str.split("$#$")
    }
}

fun main() {
    val s = Solution()
    s.decode(s.encode(listOf("this", "is", "it"))).also { println(it) }
}