package `2807_Insert_Greatest_Common_Divisors_in_Linked_List`

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

class Solution {

    tailrec fun gcd(a: Int, b: Int): Int {
        if (b == 0) return a
        return gcd(b, a % b)
    }

    fun insertGreatestCommonDivisors(head: ListNode?): ListNode? {
        var current = head

        while (current?.next != null) {
            val gcd = gcd(current.`val`, current.next!!.`val`)
            val node = ListNode(gcd)
            node.next = current.next
            current.next = node
            current = current.next
        }

        return head
    }
}

fun main() {
    val s = Solution()
    val list = ListNode(18)
    list.next = ListNode(6)
    list.next!!.next = ListNode(10)
    list.next!!.next!!.next = ListNode(3)
    s.insertGreatestCommonDivisors(list)
}