package `143_Reorder_List`

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

class Solution {
    fun reorderList(head: ListNode?): Unit {
        if (head == null)
            return

        val list = mutableListOf<ListNode>()
        var node = head
        while (node != null) {
            list.add(node)
            node = node.next
        }

        var left = 0
        var right = list.lastIndex
        while (left < right) {
            list[left].next = list[right]
            left += 1
            if (left < right) {
                list[right].next = list[left]
            }
            right -= 1
        }
        list[left].next = null
    }
}

fun main() {
    val s = Solution()
    val list = ListNode(1)
    list.next = ListNode(2)
    list.next!!.next = ListNode(3)
    list.next!!.next!!.next = ListNode(4)
    s.reorderList(list)
    val a = 1
}