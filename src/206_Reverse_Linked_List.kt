package `206_Reverse_Linked_List`

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

class Solution {
    var last:ListNode? = null

    fun reverseInternal(head: ListNode?): ListNode? {
        if (head?.next == null) {
            last = head
            return head
        } else {
            val reversed = reverseInternal(head.next)
            reversed?.next = head
            return head
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
