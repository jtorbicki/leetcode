package `21_Merge_Two_Sorted_Lists_2`

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

class Solution {
    fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
        val list = IntArray(100)
        var head: ListNode? = null
        var tail = head

        var left = list1
        var right = list2
        var size = 0

        while (left != null || right != null) {
            val leftValue = left?.`val`
            val rightValue = right?.`val`
            when {
                leftValue != null && rightValue != null -> {
                    list[size] = if (leftValue < rightValue) {
                        left = left?.next
                        leftValue
                    } else {
                        right = right?.next
                        rightValue
                    }
                }
                leftValue != null -> {
                    left = left?.next
                    list[size] = leftValue
                }
                else -> {
                    right = right?.next
                    list[size] = rightValue!!
                }
            }
            size++
        }

        for (index in 0..< size) {
            val next = ListNode(list[index])
            when (index) {
                0 -> head = next
                else -> tail?.next = next
            }
            tail = next
        }

        return head
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
