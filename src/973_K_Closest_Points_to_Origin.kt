package `973_K_Closest_Points_to_Origin`

import java.util.*
import kotlin.collections.ArrayList

class Solution {
    data class Point(val x: Int, val y: Int, val distance: Int)

    fun kClosest(points: Array<IntArray>, k: Int): Array<IntArray> {
        val queue = PriorityQueue(Comparator<Point> { p0, p1 ->
            p0.distance - p1.distance
        })

        val ps = points.map { p ->
            val x = p[0]
            val y = p[1]
            val d = x * x + y * y
            Point(x, y, d)
        }

        queue.addAll(ps)

        val result = ArrayList<Point>()

        repeat(k) {
            result.add(queue.remove())
        }

        return result.map { p -> intArrayOf(p.x, p.y) }.toTypedArray()
    }
}

fun main() {
    val s = Solution()
    s.kClosest(
        arrayOf(
            intArrayOf(3, 3),
            intArrayOf(5, -1),
            intArrayOf(-2, -4),
        ),
        2
    )
}