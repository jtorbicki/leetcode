package `20_Valid_Parentheses`

import java.util.*

class Solution {
    fun isValid(s: String): Boolean {
        val stack = LinkedList<Char>()

        for (c in s) {
            when {
                c == '(' || c == '{' || c == '[' -> stack.push(c)
                c == ')' -> {
                    if (stack.isEmpty() || stack.pop() != '(') return false
                }
                c == '}' -> {
                    if (stack.isEmpty() || stack.pop() != '{') return false
                }
                c == ']' -> {
                    if (stack.isEmpty() || stack.pop() != '[') return false
                }
            }
        }
        return stack.isEmpty()
    }

}
