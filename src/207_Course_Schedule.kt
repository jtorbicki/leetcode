package `207_Course_Schedule`

import java.util.LinkedList

class Solution {
    fun canFinish(numCourses: Int, prerequisites: Array<IntArray>): Boolean {
        if (prerequisites.isEmpty())
            return true

        val prereq = Array<MutableList<Int>>(numCourses) {
            mutableListOf()
        }
        val queue = LinkedList<Int>()

        fun createPrerequisites() {
            for (p in prerequisites) {
                val course = p[0]
                val dependsOn = p[1]
                prereq[course].add(dependsOn)
            }
        }

        createPrerequisites()

        for ((index, p) in prereq.withIndex()) {
            if (p.isEmpty())
                queue.add(index)
        }

        while (queue.isNotEmpty()) {
            val course = queue.pop()
            for ((key, set) in prereq.withIndex()) {
                if (set.contains(course)) {
                    set.remove(course)
                    if (set.isEmpty()) {
                        queue.add(key)
                    }
                }
            }
        }

        return prereq.none { it.isNotEmpty() }
    }
}

//class Solution {
//    fun canFinish(numCourses: Int, prerequisites: Array<IntArray>): Boolean {
//        val graph = Array(numCourses) {
//            mutableListOf<Int>()
//        }
//        for ((a, b) in prerequisites) graph[a].add(b)
//        val visited = IntArray(numCourses)
//
//        fun dfs(course: Int): Boolean {
//            if (visited[course] == 1) return true
//            if (visited[course] == 2) return false
//
//            visited[course] = 1
//            for (p in graph[course]) {
//                if (dfs(p)) return true
//            }
//            visited[course] = 2
//
//            return false
//        }
//
//        for (i in graph.indices) {
//            if (dfs(i)) return false
//        }
//
//        return true
//    }
//}

fun main() {
    val s = Solution()
//    s.canFinish(2, arrayOf(intArrayOf(0,1))).also { println(it) }
//    s.canFinish(2, arrayOf(intArrayOf(0,1), intArrayOf(1,0))).also { println(it) }
    s.canFinish(5, arrayOf(
        intArrayOf(1,4),
        intArrayOf(2,4),
        intArrayOf(3,1),
        intArrayOf(3,2),
    )).also { println(it) }
}
