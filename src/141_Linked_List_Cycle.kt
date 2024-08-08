package `141_Linked_List_Cycle`

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

class Solution {
    fun hasCycle(head: ListNode?): Boolean {
        var node1: ListNode? = head
        var node2: ListNode? = head

        while (true) {
            node1 = node1?.next
            node2 = node2?.next?.next
            if (node1 == null || node2 == null) return false
            else if (node1 == node2) return true
        }
    }
}
