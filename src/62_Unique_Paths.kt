package `62_Unique_Paths`

//class Solution {
//
//    fun uniquePaths(m: Int, n: Int): Int {
//        val lastRight = n - 1
//        val lastBottom = m - 1
//
//        fun canMoveRight(n: Int): Boolean = n < lastRight
//        fun canMoveDown(m: Int): Boolean = m < lastBottom
//
//        fun dfs(m: Int, n: Int): Int {
//            if (m == lastBottom && n == lastRight) {
//                return 1
//            }
//            var paths = 0
//            if (canMoveRight(n)) {
//                paths += dfs(m, n + 1)
//            }
//            if (canMoveDown(m)) {
//                paths += dfs(m + 1, n)
//            }
//
//            return paths
//        }
//
//        return dfs(0, 0)
//    }
//}

class Solution {

    fun uniquePaths(m: Int, n: Int): Int {
        val paths = Array(m) { IntArray(n) { 1 } }

        for (row in m - 2 downTo 0) {
            for (col in n - 2 downTo 0) {
                paths[row][col] = paths[row + 1][col] + paths[row][col + 1]
            }
        }

        return paths[0][0]
    }
}


fun main() {
    val solution = Solution()
    println(solution.uniquePaths( 51, 9))
}