package `79_Word_Search`

class Solution {
    fun exist(board: Array<CharArray>, word: String): Boolean {
        val rows = 0..< board.size
        val cols = 0..< board[0].size
        val directions = listOf(0 to 1, 0 to -1, 1 to 0, -1 to 0)
        val visited = mutableSetOf<Pair<Int, Int>>()

        fun dfs(row: Int, col: Int, index: Int): Boolean {
            if (index == word.length) {
                return true
            }

            if (row !in rows || col !in cols || row to col in visited || board[row][col] != word[index]) {
                return false
            }

            visited.add(row to col)
            for ((rd, cd) in directions) {
                val nr = row + rd
                val nc = col + cd
                if (dfs(nr, nc, index + 1)) return true
            }
            visited.remove(row to col)
            return false
        }

        for (row in rows) {
            for (col in cols) {
                if (dfs(row, col, 0)) return true
            }
        }

        return false
    }
}

fun main(args: Array<String>) {
    val solution = Solution()
    solution.exist(arrayOf(
        charArrayOf('a', 'b', 'c', 'e'),
        charArrayOf('s', 'f', 'e', 's'),
        charArrayOf('a', 'd', 'e', 'e'),
    ), "abceseeefs").let { println(it) }
}