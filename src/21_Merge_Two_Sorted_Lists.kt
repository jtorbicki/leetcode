package `21_Merge_Two_Sorted_Lists`

 class ListNode(var `val`: Int) {
         var next: ListNode? = null
     }

class Solution {
    fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
        var list: ListNode? = null
        var node1 = list1
        var node2 = list2
        var current: ListNode? = null

        while (node1 != null || node2 != null) {
            val v1 = node1?.`val`
            val v2 = node2?.`val`
            when {
                v1 != null && v2 != null -> {
                    if (v1 < v2) {
                        if (current == null) {
                            current = ListNode(v1)
                        } else {
                            current.next = ListNode(v1)
                            current = current.next
                        }
                        node1 = node1?.next
                    } else {
                        if (current == null) {
                            current = ListNode(v2)
                        } else {
                            current.next = ListNode(v2)
                            current = current.next
                        }
                        node2 = node2?.next
                    }
                    if (list == null) {
                        list = current
                    }
                }
                v1 == null -> {
                    if (list == null) {
                        list = node2
                    } else {
                        current?.next = node2
                    }
                    break
                }
                else -> {
                    if (list == null) {
                        list = node1
                    } else {
                        current?.next = node1
                    }
                    break
                }
            }
        }

        return list

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
