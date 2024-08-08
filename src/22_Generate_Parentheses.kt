package `22_Generate_Parentheses`

import java.util.*

class Solution {

    fun generateParenthesis(n: Int): List<String> {

        val stack = LinkedList<String>()
        val result = mutableListOf<String>()

        fun bt(open: Int, close: Int) {
            if (open == n && close == n) {
                result.add(stack.joinToString(""))
            }

            if (open < n) {
                stack.add("(")
                bt(open + 1, close)
                stack.removeLast()
            }
            if (close < open) {
                stack.add(")")
                bt(open, close + 1)
                stack.removeLast()
            }
        }

        bt(0, 0)

        return result
    }
}

fun main() {
    val s = Solution()
    s.generateParenthesis(3).also { println(it) }
}