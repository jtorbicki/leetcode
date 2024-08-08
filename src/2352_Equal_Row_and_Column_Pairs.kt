package `2352_Equal_Row_and_Column_Pairs`

class Solution {
    fun equalPairs(grid: Array<IntArray>): Int {
        val rows = grid.groupingBy { it.toList() }.eachCount()
        var result = 0

        for (i in grid[0].indices) {
            val list = mutableListOf<Int>()
            for (j in grid.indices) {
                list += grid[j][i]
            }
            result += rows[list] ?: 0
        }
        return result
    }
}

fun main(args: Array<String>) {
    val solution = Solution()
    solution.equalPairs(
        arrayOf(
            intArrayOf(3, 1, 2, 2),
            intArrayOf(1, 4, 4, 5),
            intArrayOf(2, 4, 2, 2),
            intArrayOf(2, 4, 2, 2),
        )
    ).also(::println)
}