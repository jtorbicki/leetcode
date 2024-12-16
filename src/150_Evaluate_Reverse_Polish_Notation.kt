package `150_Evaluate_Reverse_Polish_Notation`

import java.util.LinkedList

class Solution {
    fun evalRPN(tokens: Array<String>): Int {

        val stack = LinkedList<Int>()

        fun mul() {
            val f = stack.pop()
            val s = stack.pop()
            stack.push((f * s))
        }

        fun div() {
            val f = stack.pop()
            val s = stack.pop()
            stack.push((s / f))
        }

        fun add() {
            val f = stack.pop()
            val s = stack.pop()
            stack.push((f + s))
        }

        fun sub() {
            val f = stack.pop()
            val s = stack.pop()
            stack.push((s - f))
        }

        for (t in tokens) {
            when (t) {
                "*" -> mul()
                "/" -> div()
                "+" -> add()
                "-" -> sub()
                else -> stack.push(t.toInt())
            }
        }

        return stack.pop()
    }
}
