package `861_Score_After_Flipping_Matrix`

class Solution {
    fun matrixScore(grid: Array<IntArray>): Int {
        val rows = 0..grid.lastIndex
        val cols = 0..grid[0].lastIndex

        fun flipRow(r: Int) {
            for (c in cols) {
                grid[r][c] = grid[r][c] xor 1
            }
        }

        fun flipCol(c: Int) {
            for (r in rows) {
                grid[r][c] = grid[r][c] xor 1
            }
        }

        fun countOnes(c: Int): Int {
            var ones = 0
            for (r in rows) {
                ones += grid[r][c]
            }
            return ones
        }


        for (r in rows) {
            val bit = grid[r][0]
            if (bit == 0) {
                flipRow(r)
            }
        }
        for (c in 1..grid[0].lastIndex) {
            val ones = countOnes(c)
            if (ones <= rows.last / 2) {
                flipCol(c)
            }
        }

        return grid.map { it.joinToString("").toInt(2) }.sum()
    }
}

fun main() {
    val s = Solution()
    s.matrixScore(
        arrayOf(
            intArrayOf(0,0,1,1),
            intArrayOf(1,0,1,0),
            intArrayOf(1,1,0,0)
        )
    ).also { print(it) }
}