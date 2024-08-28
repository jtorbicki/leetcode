package `621_Task_Scheduler`

import java.util.PriorityQueue

class Solution {
    data class Task(val name: Char, var q: Int)

    fun leastInterval(tasks: CharArray, n: Int): Int {
        val scheduler = PriorityQueue<Task> { t1, t2 ->
            t2.q - t1.q
        }

        val map = tasks.fold(mutableMapOf<Char, Int>()) { acc, task ->
            if (acc.contains(task)) {
                acc[task] = acc[task]!! + 1
            } else {
                acc[task] = 1
            }
            acc
        }

        scheduler.addAll(map.entries.map { Task(it.key, it.value) })

        val work = ArrayList<Char>()

        var tick = 0
        val restQueue = mutableMapOf<Int, Task>()

        while (scheduler.isNotEmpty() || restQueue.isNotEmpty()) {
            val task = scheduler.poll() ?: Task(' ', 1)
            work.add(task.name)
            if (task.q > 1) {
                task.q -= 1
                restQueue[tick + n + 1] = task
            }
            tick++
            restQueue.get(tick)?.let {
                scheduler.add(it)
                restQueue.remove(tick)
            }
        }

        return work.size
    }
}

fun main() {
    val s = Solution()
    s.leastInterval(charArrayOf('A', 'A', 'A', 'B', 'B', 'B'), 2).also { println(it) }
}