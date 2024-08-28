package `36_Valid_Sudoku`

class Solution {

    private fun validate(set: CharArray): Boolean {
        val filtered = set.filter { it.isDigit() }
        return filtered.toSet().size == filtered.size
    }

    fun isValidSudoku(board: Array<CharArray>): Boolean {
        val rows = 0..board.lastIndex
        val cols = 0..board[0].lastIndex

        for (row in rows) {
            val rowValid = validate(board[row])
            if (!rowValid) return false
        }

        for (col in cols) {
            val list = mutableListOf<Char>()
            for (row in rows) {
                list.add(board[row][col])
            }
            val colValid = validate(list.toCharArray())
            if (!colValid) return false
        }

        for (squareCol in 0..<3) {
            for (squareRow in 0..<3) {
                val list = mutableListOf<Char>()
                for (col in 0..<3) {
                    for (row in 0..<3) {
                        list.add(board[squareRow * 3 + row][squareCol * 3 + col])
                    }
                }
                val squareValid = validate(list.toCharArray())
                if (!squareValid) return false
            }
        }

        return true
    }
}

fun main() {
    val s = Solution()
    val board = arrayOf(
//        charArrayOf('5', '3', '.', '.', '7', '.', '.', '.', '.'),
//        charArrayOf('6', '.', '.', '1', '9', '5', '.', '.', '.'),
//        charArrayOf('.', '9', '8', '.', '.', '.', '.', '6', '.'),
//        charArrayOf('8', '.', '.', '.', '6', '.', '.', '.', '3'),
//        charArrayOf('4', '.', '.', '8', '.', '3', '.', '.', '1'),
//        charArrayOf('7', '.', '.', '.', '2', '.', '.', '.', '6'),
//        charArrayOf('.', '6', '.', '.', '.', '.', '2', '8', '.'),
//        charArrayOf('.', '.', '.', '4', '1', '9', '.', '.', '5'),
//        charArrayOf('.', '.', '.', '.', '8', '.', '.', '7', '9')
        charArrayOf('.', '.', '4', '.', '.', '.', '6', '3', '.'),
        charArrayOf('.', '.', '.', '.', '.', '.', '.', '.', '.'),
        charArrayOf('5', '.', '.', '.', '.', '.', '.', '9', '.'),
        charArrayOf('.', '.', '.', '5', '6', '.', '.', '.', '.'),
        charArrayOf('4', '.', '3', '.', '.', '.', '.', '.', '1'),
        charArrayOf('.', '.', '.', '7', '.', '.', '.', '.', '.'),
        charArrayOf('.', '.', '.', '5', '.', '.', '.', '.', '.'),
        charArrayOf('.', '.', '.', '.', '.', '.', '.', '.', '.'),
        charArrayOf('.', '.', '.', '.', '.', '.', '.', '.', '.')
    )
    s.isValidSudoku(board).also { println(it) }
}