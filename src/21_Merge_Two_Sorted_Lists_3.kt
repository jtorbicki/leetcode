package `21_Merge_Two_Sorted_Lists_3`

 class ListNode(var `val`: Int) {
         var next: ListNode? = null
     }

class Solution {
    fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
        val holder = ListNode(0)
        var current = holder
        var iter1 = list1
        var iter2 = list2

        while (iter1 != null || iter2 != null) {
            when {
                iter1 != null && iter2 != null -> {
                    if (iter1.`val` <= iter2.`val`) {
                        current.next = iter1
                        iter1 = iter1.next
                    } else {
                        current.next = iter2
                        iter2 = iter2.next
                    }
                }
                iter1 != null -> {
                    current.next = iter1
                    iter1 = iter1.next
                }
                else -> {
                    current.next = iter2
                    iter2 = iter2!!.next
                }
            }
            current = current.next!!
        }

        return holder.next
    }
}

fun main(args: Array<String>) {
    val solution = Solution()
    val list1 = ListNode(1)
    list1.next = ListNode(2)
    list1.next!!.next = ListNode(4)
    val list2 = ListNode(1)
    list2.next = ListNode(3)
    list2.next!!.next = ListNode(4)
    val result = solution.mergeTwoLists(list1, list2)
    val a = 1
}
