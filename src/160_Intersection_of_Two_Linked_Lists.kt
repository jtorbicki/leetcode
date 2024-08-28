package `160_Intersection_of_Two_Linked_Lists`

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

class Solution {
    fun getIntersectionNode(headA: ListNode?, headB: ListNode?): ListNode? {
        val heads1 = mutableListOf(headA, headB)
        val heads2 = mutableListOf(headB, headA)
        var node1 = heads1.removeFirst()
        var node2 = heads2.removeFirst()

        while (node1 != node2) {
            node1 = node1?.next ?: heads1.removeFirstOrNull()
            node2 = node2?.next ?: heads2.removeFirstOrNull()
        }

        return node1
    }
}
