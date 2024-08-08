package `739_Daily_Temperatures`

import java.util.*

class Solution {
    fun dailyTemperatures(temperatures: IntArray): IntArray {
        if (temperatures.isEmpty()) return intArrayOf(0)

        val stack = LinkedList<Pair<Int, Int>>()
        val output = IntArray(temperatures.size)

        stack.push(temperatures[0] to 0)
        for (i in 1..temperatures.lastIndex) {
            val newTemp = temperatures[i]
            while (stack.isNotEmpty()) {
                if (stack.peek().first < newTemp) {
                    val index = stack.pop().second
                    output[index] = i - index
                } else {
                    break
                }
            }
            stack.push(newTemp to i)
        }

        return output
    }
}

fun main(args: Array<String>) {
    val s = Solution().dailyTemperatures(intArrayOf(73,74,75,71,69,72,76,73)).also { println(it.contentToString()) }
}