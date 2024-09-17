package `1851_Minimum_Interval_to_Include_Each_Query`

class Solution {

    data class Node(val from: Int, val to: Int, var maxTo: Int, val left: Node?, val right: Node?) {
        fun queryMin(q: Int): Int? {
            val range = from..to

            if (q !in range && left == null && right == null) {
                return null
            }

            val qNode = if (q in range) {
                to - from + 1
            } else null

            val qLeft = if (left != null && left.maxTo >= q) {
                left.queryMin(q)
            } else null
            val qRight = if (right != null && from < q && maxTo >= q) {
                right.queryMin(q)
            } else if (right != null && right.from == q) {
                right.queryMin(q)
            } else null

            return listOfNotNull(qNode, qLeft, qRight).minOrNull() ?: -1
        }
    }

    fun minInterval(intervals: Array<IntArray>, queries: IntArray): IntArray {
        intervals.sortBy { it[0] }

        fun buildTree(leftIndex: Int, rightIndex: Int): Node? {
            if (leftIndex > rightIndex) return null

            val middle = leftIndex + (rightIndex - leftIndex) / 2
            val (lo, hi) = intervals[middle]

            val node = Node(lo, hi, hi, buildTree(leftIndex, middle - 1), buildTree(middle + 1, rightIndex))
            node.maxTo = maxOf(hi, node.left?.maxTo ?: 0, node.right?.maxTo ?: 0)
            return node
        }

        if (intervals.isEmpty()) return intArrayOf()

        val tree = buildTree(0, intervals.lastIndex) ?: return intArrayOf()

        return queries.map { tree.queryMin(it) }.filterNotNull().toTypedArray().toIntArray()
    }
}

fun main() {
    val s = Solution()
    s.minInterval(
        arrayOf(
            intArrayOf(9, 9),
            intArrayOf(1, 10),
            intArrayOf(1, 3),
            intArrayOf(9, 10),
            intArrayOf(8, 8),
        ), intArrayOf(1)
    ).also { println(it.contentToString()) }
}