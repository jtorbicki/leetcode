package `200_Number_of_Islands_2`

class Solution {
    fun numIslands(grid: Array<CharArray>): Int {
        val rows = 0..grid.lastIndex
        val cols = 0..grid[0].lastIndex

        var count = 0

        val directions = listOf(-1 to 0, 1 to 0, 0 to -1, 0 to 1)

        fun floodFill(r: Int, c: Int): Boolean {
            if (r !in rows || c !in cols || grid[r][c] == '0') {
                return false
            }

            grid[r][c] = '0'

            for ((nr, nc) in directions) {
                floodFill(nr + r, nc + c)
            }

            return true
        }

        for (r in rows) {
            for (c in cols) {
                if (floodFill(r, c)) {
                    count += 1
                }
            }
        }

        return count
    }
}
