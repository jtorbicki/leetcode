package `394_Decode_String`

class Solution {

    fun isNumeric(toCheck: String): Boolean {
        return toCheck.all { char -> char.isDigit() }
    }

    fun decodeString(s: String): String {

        val tokens = mutableListOf<String>()

        var number = ""
        var token = ""

        for (c in s) {
            when {
                c.isDigit() -> number += c
                c.isLetter() -> token += c
                c == '[' -> {
                    if (token.isNotEmpty()) tokens.add(token)
                    token = ""
                    tokens.add(number)
                    number = ""
                }
                c == ']' -> {
                    if (token.isNotEmpty()) tokens.add(token)
                    token = ""
                    val list = mutableListOf<String>()
                    while (!isNumeric(tokens.last())) {
                        list.add(0, tokens.removeLast())
                    }
                    val str = list.joinToString("")
                    var result = ""
                    repeat(tokens.removeLast().toInt()) {
                        result += str
                    }
                    tokens.add(result)
                }
            }
        }

        return tokens.joinToString("") + token
    }
}

fun main(args: Array<String>) {
    val s = Solution().decodeString("2[abc]3[cd]ef").also(::println)
}
