package `119_Pascal's_Triangle_II`

import java.util.LinkedList

class Solution {
    fun getRow(rowIndex: Int): List<Int> {
        var row = mutableListOf(1)
        repeat(rowIndex) {
            val nextRow = LinkedList<Int>()
            for (i in 1..row.lastIndex) {
                nextRow += (row[i] + row[i-1])
            }
            nextRow.addFirst(1)
            nextRow.addLast(1)
            row = nextRow
        }
        return row
    }
}

fun main() {
    val s = Solution()
    s.getRow(0).also { println(it) }
    s.getRow(1).also { println(it) }
    s.getRow(3).also { println(it) }
    s.getRow(5).also { println(it) }
}