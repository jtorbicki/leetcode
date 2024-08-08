package `155_Min_Stack`

import java.util.LinkedList

class MinStack() {

    val stack = LinkedList<Int>()
    val min = LinkedList<Int>()

    fun push(`val`: Int) {
        stack.add(`val`)
        when {
            min.isEmpty() -> min.add(`val`)
            min.last() < `val` -> min.add(min.last())
            else -> min.add(`val`)
        }
    }

    fun pop() {
        stack.removeLast()
        min.removeLast()
    }

    fun top(): Int {
        return stack.last()
    }

    fun getMin(): Int {
        return min.last()
    }

}

fun main() {
    val minStack = MinStack()
    minStack.push(-2);
    minStack.push(0);
    minStack.push(-3);
    minStack.getMin(); // return -3
    minStack.pop();
    minStack.top();    // return 0
    minStack.getMin(); // return -2
}