package `261_Graph_Valid_Tree`

class Solution {
    fun validTree(n: Int, edges: Array<IntArray>): Boolean {
        val visited = mutableSetOf<Int>()

        for (edge in edges) {
            val (from, to) = edge
            when {
                from in visited && to in visited -> break
                else -> {
                    visited += from
                    visited += to
                }
            }
        }

        if (n == 1 && edges.isEmpty())
            return true

        return visited.size == n && edges.size == n - 1
    }
}

fun main() {
    val s = Solution()
    s.validTree(1, arrayOf()).also { println(it) }
}