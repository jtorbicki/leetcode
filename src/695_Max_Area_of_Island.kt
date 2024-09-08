package `695_Max_Area_of_Island`

class Solution {
    fun maxAreaOfIsland(grid: Array<IntArray>): Int {
        var max = 0
        val rows = 0..grid.lastIndex
        val cols = 0..grid[0].lastIndex
        var islandNumber = 2
        var visited = 0
        val directions = listOf(-1 to 0, 1 to 0, 0 to -1, 0 to 1)

        fun dfs(row: Int, col: Int, islandNumber: Int): Boolean {
            if (row !in rows || col !in cols || grid[row][col] != 1)
                return false

            grid[row][col] = islandNumber
            visited += 1

            for (d in directions) {
                val nr = row + d.first
                val nc = col + d.second
                dfs(nr, nc, islandNumber)
            }

            return true
        }

        for (row in rows) {
            for (col in cols) {
                if (dfs(row, col, islandNumber)) {
                    islandNumber += 1
                    max = maxOf(max, visited)
                    visited = 0
                }
            }
        }

        return max
    }
}
