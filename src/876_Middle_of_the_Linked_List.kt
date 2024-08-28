package `876_Middle_of_the_Linked_List`

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

class Solution {
    fun middleNode(head: ListNode?): ListNode? {
        var slow: ListNode? = head
        var fast: ListNode? = head

        while (true) {
            if (fast?.next != null) {
                slow = slow?.next
            } else {
                break;
            }

            fast = fast.next?.next
        }

        return slow
    }
}

fun main() {
    val s = Solution()
    val list = ListNode(1)
    list.next = ListNode(2)
    list.next!!.next = ListNode(3)
    list.next!!.next!!.next = ListNode(4)
    list.next!!.next!!.next!!.next = ListNode(5)
    s.middleNode(list)
}

// [1, 2, 3, 4, 5, 6, 7]