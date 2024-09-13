package `23_Merge_k_Sorted_Lists`

import java.util.PriorityQueue

class ListNode(var `val`: Int) {
         var next: ListNode? = null
 }

class Solution {
    fun mergeKLists(lists: Array<ListNode?>): ListNode? {
        val holder = ListNode(0)

        val queue = PriorityQueue<Int>()
        for (list in lists) {
            var node = list
            while (node != null) {
                queue.add(node.`val`)
                node = node.next
            }
        }

        var node: ListNode? = holder
        while (queue.isNotEmpty()) {
            val value = queue.remove()
            node?.next = ListNode(value)
            node = node?.next
        }

        return holder.next
    }
}