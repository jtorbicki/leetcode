package `206_Reverse_Linked_List`

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

class Solution {
    var last:ListNode? = null

    fun reverseInternal(node: ListNode?): ListNode? {
        if (node?.next == null) {
            last = node
            return node
        } else {
            val reversed = reverseInternal(node.next)
            reversed?.next = node
            return node
        }
    }

    fun reverseList(head: ListNode?): ListNode? {
        val reversed = reverseInternal(head)
        reversed?.next = null
        return last
    }
}

fun main() {
    val head = ListNode(1)
    head.next = ListNode(2)
    head.next!!.next = ListNode(3)
    val a = Solution().reverseList(head)
    val b = 1
}
