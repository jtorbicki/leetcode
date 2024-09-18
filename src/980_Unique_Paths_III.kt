package `980_Unique_Paths_III`

class Solution {
    fun uniquePathsIII(grid: Array<IntArray>): Int {
        val rows = 0..grid.lastIndex
        val cols = 0..grid[0].lastIndex

        val visited = mutableSetOf<Pair<Int, Int>>()
        val directions = listOf(-1 to 0, 1 to 0, 0 to -1, 0 to 1)

        fun dfs(row: Int, col: Int, zeros: Int): Int {
            when {
                row !in rows || col !in cols -> return 0
                row to col in visited -> return 0
                grid[row][col] == 2 && visited.size == zeros -> return 1
                visited.size == zeros -> return 0
                grid[row][col] == -1 -> return 0
            }

            visited.add(row to col)
            return directions.sumOf { (r, c) -> dfs(row + r, col + c, zeros) }.also {
                visited.remove(row to col)
            }
        }

        var zeros = 0
        for (r in rows)
            for (c in cols)
                if (grid[r][c] == 0)
                    zeros += 1

        var result = 0
        for (r in rows)
            for (c in cols)
                if (grid[r][c] == 1)
                    result = dfs(r, c, zeros + 1)

        return result
    }
}

fun main() {
    val s = Solution()
    s.uniquePathsIII(
        arrayOf(
            intArrayOf(1, 0, 0, 0),
            intArrayOf(0, 0, 0, 0),
            intArrayOf(0, 0, 2, -1)
        )
    ).also { println(it) }
}
