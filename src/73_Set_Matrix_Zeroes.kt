package `73_Set_Matrix_Zeroes`

import java.util.*

class Solution {

    enum class Direction {
        UP, DOWN, LEFT, RIGHT
    }

    data class Arrow(val x: Int, val y: Int, val direction: Direction)

    fun setZeroes(matrix: Array<IntArray>): Unit {
        val queue = LinkedList<Arrow>()

        for (y in matrix.indices) {
            for (x in matrix[0].indices) {
                if (matrix[y][x] == 0) {
                    val all = Direction.entries.map {
                        Arrow(x, y, it)
                    }
                    queue.addAll(all)
                }
            }
        }

        while (queue.isNotEmpty()) {
            val (x, y, direction) = queue.pop()
            matrix[y][x] = 0
            when {
                direction == Direction.UP && y > 0 -> queue.add(Arrow(x, y - 1, direction))
                direction == Direction.DOWN && y < matrix.lastIndex -> queue.add(Arrow(x, y + 1, direction))
                direction == Direction.LEFT && x > 0 -> queue.add(Arrow(x - 1, y, direction))
                direction == Direction.RIGHT && x < matrix[0].lastIndex -> queue.add(Arrow(x + 1, y, direction))
            }
        }
    }
}

fun main() {
    val s = Solution()
    val arr = arrayOf(
        intArrayOf(1, 1, 1),
        intArrayOf(1, 0, 1),
        intArrayOf(1, 1, 1),
    )
    s.setZeroes(arr)
    println(arr.contentToString())
}
