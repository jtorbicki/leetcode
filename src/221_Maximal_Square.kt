package `221_Maximal_Square`

//class Solution {
//    fun maximalSquare(matrix: Array<CharArray>): Int {
//        val rows = matrix.indices
//        val cols = matrix[0].indices
//
//        fun calculateSquareSize(tr: Int, lc: Int): Int {
//            var result = 1
//            var br = tr + 1
//            var rc = lc + 1
//            while (true) {
//                for (row in tr..br) {
//                    for (col in lc..rc) {
//                        if (row !in rows || col !in cols || matrix[row][col] == '0') {
//                            return result
//                        }
//                    }
//                }
//                val size = br - tr + 1
//                result = size * size
//                br += 1
//                rc += 1
//            }
//        }
//
//        var max = 0
//        for (r in rows) {
//            for (c in cols) {
//                if (matrix[r][c] == '1') {
//                    max = maxOf(max, calculateSquareSize(r, c))
//                }
//            }
//        }
//
//        return max
//    }
//}

class Solution {
    fun maximalSquare(matrix: Array<CharArray>): Int {
        val rows = matrix.indices
        val cols = matrix[0].indices
        val dp = Array(matrix.size) { IntArray(matrix[0].size) }
        val lastRow = matrix.lastIndex
        val lastCol = matrix[0].lastIndex

        var max = 0

        for (row in matrix.lastIndex downTo 0) {
            for (col in matrix[0].lastIndex downTo  0) {
                when {
                    row == lastRow || col == lastCol -> dp[row][col] = if (matrix[row][col] == '0') 0 else 1
                    else -> {
                        val sameRow = dp[row][col + 1]
                        val sameCol = dp[row + 1][col]
                        val diag = dp[row + 1][col + 1]
                        val current = if (matrix[row][col] == '0') 0 else 1
                        if (current != 0) {
                            val value = minOf(sameRow, sameCol, diag) + 1
                            dp[row][col] = value
                        } else {
                            dp[row][col] = if (matrix[row][col] == '0') 0 else 1
                        }
                    }
                }
            }
        }

        for (row in matrix.lastIndex downTo 0) {
            for (col in matrix[0].lastIndex downTo  0) {
                max = maxOf(max, dp[row][col])
            }
        }

        return max * max
    }
}


fun main() {
    val s = Solution()
    s.maximalSquare(
        arrayOf(
            charArrayOf('1', '1', '1', '1', '0'),
            charArrayOf('1', '1', '1', '1', '0'),
            charArrayOf('1', '1', '1', '1', '1'),
            charArrayOf('1', '1', '1', '1', '1'),
            charArrayOf('0', '0', '1', '1', '1')
        )
    ).also { println(it) }
}