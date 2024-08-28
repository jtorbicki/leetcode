package `232_Implement_Queue_using_Stacks`

import java.util.*

class MyQueue() {
    private val push = LinkedList<Int>()
    private val pop = LinkedList<Int>()

    fun push(x: Int) {
        push.add(x)
    }

    fun pop(): Int {
        if (pop.isEmpty())
            populatePop()

        return pop.pollLast()
    }

    fun peek(): Int {
        if (pop.isEmpty())
            populatePop()

        return pop.last()
    }

    fun empty(): Boolean {
        return push.isEmpty() && pop.isEmpty()
    }

    private fun populatePop() {
        while (push.isNotEmpty()) {
            pop.add(push.pollLast())
        }
    }
}

fun main() {
    val s = MyQueue()
    s.push(1)
    s.push(2)
    s.push(3)
    s.peek().also { println(it) }
    s.pop().also { println(it) }
    s.pop().also { println(it) }
    s.pop().also { println(it) }
}