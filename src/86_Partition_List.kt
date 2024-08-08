package `86_Partition_List`

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

class Solution {
    fun partition(head: ListNode?, x: Int): ListNode? {
        var left: ListNode? = null
        var lastLeft: ListNode? = null
        var right: ListNode? = null
        var lastRight: ListNode? = null

        var node = head
        while (node != null) {
            if (node.`val` < x) {
                if (lastLeft == null) {
                    left = node
                    lastLeft = node
                } else {
                    lastLeft.next = node
                    lastLeft = node
                }
            } else {
                if (lastRight == null) {
                    right = node
                    lastRight = node
                } else {
                    lastRight.next = node
                    lastRight = node
                }
            }
            node = node.next
        }

        lastLeft?.next = right
        lastRight?.next = null

        return left ?: right
    }
}

fun main() {
    val s = Solution()
    val list = ListNode(1)
    list.next = ListNode(4)
    list.next!!.next = ListNode(3)
    list.next!!.next!!.next = ListNode(2)
    list.next!!.next!!.next!!.next = ListNode(5)
    list.next!!.next!!.next!!.next!!.next = ListNode(2)
    val r = s.partition(list, 3)
    val a = 1
}