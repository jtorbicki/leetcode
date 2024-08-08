package `54_Spiral_Matrix`

class Solution {
    fun spiralOrder(matrix: Array<IntArray>): List<Int> {
        val rows = 0..<matrix.size
        val cols = 0..<matrix[0].size
        val elements = matrix.size * matrix[0].size
        val visited = mutableSetOf<Pair<Int, Int>>()
        val result = mutableListOf<Int>()

        fun nextDirection(direction: Pair<Int, Int>): Pair<Int, Int> = when (direction) {
            Pair(0, 1) -> Pair(1, 0)
            Pair(1, 0) -> Pair(0, -1)
            Pair(0, -1) -> Pair(-1, 0)
            else -> Pair(0, 1)
        }

        fun dfs(row: Int, col: Int, direction: Pair<Int, Int>) {
            val value = matrix[row][col]
            result.add(value)
            visited.add(row to col)
            val nr = row + direction.first
            val nc = col + direction.second
            if (nr in rows && nc in cols && nr to nc !in visited) {
                dfs(nr, nc, direction)
            } else if (result.size < elements) {
                val next = nextDirection(direction)
                dfs(row + next.first, col + next.second, next)
            }
        }

        dfs(0, 0, 0 to 1)

        return result.toList()
    }
}

fun main(args: Array<String>) {
    val solution = Solution()
    println(
        solution.spiralOrder(
            arrayOf(
                intArrayOf(1, 2, 3, 4), intArrayOf(5, 6, 7, 8), intArrayOf(9, 10, 11, 12), intArrayOf(13, 14, 15, 16)
            )
        )
    )
}