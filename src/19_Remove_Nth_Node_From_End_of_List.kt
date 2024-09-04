package `19_Remove_Nth_Node_From_End_of_List`

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

class Solution {
    fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
        val preHead = ListNode(0)
        preHead.next = head

        var prev:ListNode? = preHead
        var next:ListNode? = preHead

        repeat(n + 1) {
            next = next?.next
        }

        while (next != null) {
            next = next?.next
            prev = prev?.next
        }

        prev?.next = prev?.next?.next

        return preHead.next
    }
}

fun main() {
    val s = Solution()
    val list = ListNode(1)
    list.next = ListNode(2)
//    list.next!!.next = ListNode(3)
//    list.next!!.next!!.next = ListNode(4)
//    list.next!!.next!!.next!!.next = ListNode(5)
    s.removeNthFromEnd(list, 1)
}