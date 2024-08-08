package `841_Keys_and_Rooms`

class Solution {
    fun canVisitAllRooms(rooms: List<List<Int>>): Boolean {
        if (rooms.size <= 1) return true

        val queue = mutableListOf<Int>()
        val visited = mutableListOf<Int>()

        queue.addAll(rooms[0])
        visited.add(0)

        while (queue.isNotEmpty()) {
            val key = queue.removeFirst()
            if (!visited.contains(key)) {
                queue.addAll(rooms[key])
                visited.add(key)
            }
        }

        return visited.size == rooms.size
    }
}

fun main(args: Array<String>) {
    val solution = Solution()
    solution.canVisitAllRooms(listOf(
        listOf(1, 3),
        listOf(3, 0, 1),
        listOf(2),
        listOf(0),
    )).also(::println)
}