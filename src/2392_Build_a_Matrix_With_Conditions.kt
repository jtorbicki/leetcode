package `2392_Build_a_Matrix_With_Conditions`

import java.util.*

class Solution {
    fun buildMatrix(k: Int, rowConditions: Array<IntArray>, colConditions: Array<IntArray>): Array<IntArray> {

        fun ts(array: Array<IntArray>): IntArray? {
            val map = mutableMapOf<Int, MutableSet<Int>>()
            val result = IntArray(k + 1)

            for (i in 1..k) {
                map[i] = mutableSetOf()
            }

            for (dep in array) {
                val value = dep[0]
                val dependsOn = dep[1]
                map[value]!!.add(dependsOn)
            }

            val queue = LinkedList<Int>()
            val numbers = map.entries.filter { it.value.isEmpty() }.map { it.key }
            queue.addAll(numbers)

            var index = k - 1
            while (queue.isNotEmpty()) {
                val number = queue.removeFirst()
                for (entry in map) {
                    if (entry.value.contains(number)) {
                        entry.value.remove(number)
                        if (entry.value.isEmpty()) {
                            queue.add(entry.key)
                        }
                    }
                }
                result[number] = index
                index -= 1
            }

            if (map.values.any { it.isNotEmpty() }) return null

            return result
        }

        val rows = ts(rowConditions)
        val cols = ts(colConditions)

        if (rows != null && cols != null) {
            val matrix = Array(k) { IntArray(k) }
            for (i in 1..k) {
                val row = rows[i]
                val col = cols[i]
                matrix[row][col] = i
            }
            return matrix
        }

        return emptyArray()
    }
}

fun main() {
    val s = Solution()
    s.buildMatrix(
        3,
        arrayOf(
            intArrayOf(1, 2),
            intArrayOf(2, 1),
        ),
        arrayOf(
            intArrayOf(2, 1),
            intArrayOf(3, 2),
        ),
    ).also {
        for (row in it) {
            println(row.contentToString())
        }
    }
}