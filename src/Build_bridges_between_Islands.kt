package Build_bridges_between_Islands

import java.util.*

data class Bridge(val island1: Int, val island2: Int, val length: Int, val sr: Int, val sc: Int, val er: Int, val ec: Int)
data class Vector(val length: Int, val direction: Pair<Int, Int>)

fun main() {
    val board = arrayOf(
        intArrayOf(0, 1, 1, 0, 0, 0, 0),
        intArrayOf(0, 0, 1, 0, 0, 0, 1),
        intArrayOf(0, 0, 1, 1, 1, 0, 1),
        intArrayOf(0, 0, 0, 0, 0, 0, 0),
        intArrayOf(0, 0, 0, 0, 0, 1, 1)
    )

    val rows = 0..board.lastIndex
    val cols = 0..board[0].lastIndex
    var islandId = 2

    val directions = listOf(
        -1 to 0, 1 to 0, 0 to -1, 0 to 1
    )

    fun dfs(r: Int, c: Int, islandId: Int): Boolean {
        if (r in rows && c in cols && board[r][c] == 1) {
            board[r][c] = islandId
            for (d in directions) {
                val nr = r + d.first
                val nc = c + d.second
                dfs(nr, nc, islandId)
            }
            return true
        }
        return false
    }

    fun bfs(r: Int, c: Int, mark: Int): List<Bridge> {
        if (mark == 0)
            return emptyList()

        val queue = LinkedList<Vector>()
        for (d in directions) {
            queue.add(Vector(0, d))
        }

        val bridges = mutableListOf<Bridge>()

        while (queue.isNotEmpty()) {
            val (length, direction) = queue.remove()
            val newLength = length + 1
            val nr = r + direction.first * newLength
            val nc = c + direction.second * newLength
            if (nr in rows && nc in cols) {
                when {
                    board[nr][nc] == 0 -> {
                        queue.add(Vector(newLength, direction))
                    }
                    board[nr][nc] != mark -> {
                        bridges.add(Bridge(mark, board[nr][nc], newLength, r, c, nr, nc))
                    }
                }
            }
        }

        return bridges
    }

    fun findMST(allBridges: List<Bridge>): List<Bridge> {
        val heap = PriorityQueue(Comparator<Bridge> { b1, b2 ->
            b1.length - b2.length
        })
        heap.addAll(allBridges)

        val visited = mutableSetOf<Int>()
        val bridges = mutableListOf<Bridge>()

        do  {
            val bridge = heap.poll()
            if (bridge.island1 !in visited || bridge.island2 !in visited) {
                visited.add(bridge.island1)
                visited.add(bridge.island2)
                bridges.add(bridge)
            }
        } while (heap.isNotEmpty())
        return bridges
    }

    for (r in rows) {
        for (c in cols) {
            if (dfs(r, c, islandId))
                islandId += 1
        }
    }

    val allBridges = mutableListOf<Bridge>()
    for (r in rows) {
        for (c in cols) {
            allBridges.addAll(bfs(r, c, board[r][c]))
        }
    }

    findMST(allBridges).map{
        "[[${it.sr}, ${it.sc}], [${it.er}, ${it.ec}]]"
    }.also { println(it) }
}
