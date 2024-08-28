package `215_Kth_Largest_Element_in_an_Array`

import java.util.*

class Solution {
    fun findKthLargest(nums: IntArray, k: Int): Int {
        val queue = PriorityQueue(Comparator<Int> { p0, p1 ->
            p1 - p0
        })
        queue.addAll(nums.toList())
        repeat(k - 1) {
            queue.poll()
        }
        return queue.peek()
    }
}

fun main(args: Array<String>) {
    val solution = Solution()
    solution.findKthLargest(intArrayOf(3, 2, 1, 5, 6, 4), 4)
}