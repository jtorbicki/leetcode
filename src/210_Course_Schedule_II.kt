package `210_Course_Schedule_II`

import java.util.*

class Solution {
    fun findOrder(numCourses: Int, prerequisites: Array<IntArray>): IntArray {
        val map = mutableMapOf<Int, MutableSet<Int>>()

        for (n in 0..<numCourses) {
            map.put(n, mutableSetOf())
        }

        for (p in prerequisites) {
            val course = p[0]
            val dependsOn = p[1]
            map[course]!!.add(dependsOn)
        }

        val queue = LinkedList<Int>()
        val result = mutableListOf<Int>()
        queue.addAll(map.entries.filter { it.value.isEmpty() }.map { it.key })

        while (queue.isNotEmpty()) {
            val course = queue.pop()
            result.add(course)
            for ((key, deps) in map.entries) {
                if (deps.remove(course) && deps.isEmpty()) {
                    queue.add(key)
                }
            }
        }

        return if (result.size >= numCourses) result.toIntArray() else intArrayOf()
    }
}

fun main() {
    val s = Solution()
    s.findOrder(2, arrayOf(intArrayOf(0, 1))).also { println(it.contentToString()) }
}