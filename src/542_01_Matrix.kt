package `542_01_Matrix`

import java.util.LinkedList

const val MAGIC = -1

class Solution {

    data class Point(val r: Int, val c: Int)

    fun updateMatrix(mat: Array<IntArray>): Array<IntArray> {
        val rows = 0..< mat.size
        val cols = 0..< mat[0].size
        val queue = LinkedList<Point>()

        for (r in rows) {
            for (c in cols) {
                val value = mat[r][c]
                if (value == 0) {
                    queue.add(Point(r, c))
                } else {
                    mat[r][c] = MAGIC
                }
            }
        }

        val directions = listOf(Point(-1, 0), Point(1, 0), Point(0, -1), Point(0, 1))

        while (queue.isNotEmpty()) {
            val point = queue.removeFirst()
            for (d in directions) {
                val nr = point.r + d.r
                val nc = point.c + d.c
                if (nr in rows && nc in cols && mat[nr][nc] == MAGIC) {
                    mat[nr][nc] = mat[point.r][point.c] + 1
                    queue.add(Point(nr, nc))
                }
            }
        }

        return mat
    }
}

fun main() {
    val s = Solution()
    s.updateMatrix(
        arrayOf(
            intArrayOf(0, 0, 0),
            intArrayOf(0, 1, 0),
            intArrayOf(1, 1, 1),
        )
    )
}