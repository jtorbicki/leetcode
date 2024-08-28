package `200_Number_of_Islands`

import java.util.LinkedList

class Solution {
    fun numIslands(grid: Array<CharArray>): Int {
        val rows = 0..grid.lastIndex
        val cols = 0..grid[0].lastIndex

        var number = 0

        fun flood(r: Int, c: Int) {
            val queue = LinkedList<Pair<Int, Int>>()
            queue.add(r to c)

            val directions = listOf(
                -1 to 0, 1 to 0, 0 to -1, 0 to 1
            )

            while (queue.isNotEmpty()) {
                val point = queue.remove()
                for (d in directions) {
                    val nr = point.first + d.first
                    val nc = point.second + d.second

                    if (nr in rows && nc in cols && grid[nr][nc] == '1') {
                        queue.add(nr to nc)
                        grid[nr][nc] = '0'
                    }
                }
            }
        }

        for (r in rows) {
            for (c in cols) {
                val value = grid[r][c]
                if (value == '1') {
                    flood(r, c)
                    number += 1
                }
            }
        }

        return number
    }
}
