package `120_Triangle`

class Solution {
    fun minimumTotal(triangle: List<List<Int>>): Int {

        fun dfs(level: Int, element: Int): Int {
            if (level == triangle.lastIndex) {
                return  triangle[level][element]
            }

            val result = minOf(dfs(level + 1, element), dfs(level + 1, element + 1))

            return result + triangle[level][element]
        }

        return dfs(0, 0)
    }
}

fun main() {
    val s = Solution()
    s.minimumTotal(
        listOf(
            listOf(-1),
            listOf(2,3),
            listOf(1,-1,-3),
        )
    ).also { println(it) }
}