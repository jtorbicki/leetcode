package `435_Non-overlapping_Intervals`

import java.util.*

class Solution {
    fun eraseOverlapIntervals(intervals: Array<IntArray>): Int {
        if (intervals.size <= 1) return 0

        intervals.sortWith { v1, v2 ->
            v1[0] - v2[0]
        }

        val list = LinkedList<IntArray>()
        list.addAll(intervals)

        var i = 0
        var j = 1
        var size = list.size

        while (j < size) {
            val first = list[i]
            val second = list[j]
            if (second[0] >= first[0] && second[0] < first[1] ||
                second[1] > first[0] && second[1] < first[1] ||
                second[1] == first[0] && second[1] == first[1]) {
                when {
                    first[1] > second[1] -> list.removeAt(i)
                    else -> list.removeAt(j)
                }
                size--
            } else {
                i++
                j++
            }
        }

        return intervals.size - list.size
    }
}

fun main(args: Array<String>) {
    val solution = Solution()
    solution.eraseOverlapIntervals(
        arrayOf(
            intArrayOf(1, 100),
            intArrayOf(11, 22),
            intArrayOf(1, 11),
            intArrayOf(2, 12),
        )
    ).also(::println)
}
