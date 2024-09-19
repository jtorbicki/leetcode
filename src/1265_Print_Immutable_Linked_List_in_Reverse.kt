package `1265_Print_Immutable_Linked_List_in_Reverse`

import java.util.*

interface ImmutableListNode {
    fun getNext(): ImmutableListNode?
    fun printValue()
}


class Solution {
    fun printLinkedListInReverse(head: ImmutableListNode?) {
        val stack = LinkedList<ImmutableListNode>()

        var current = head
        while (current != null) {
            stack.push(current)
            current = current.getNext()
        }
        while (stack.isNotEmpty()) {
            stack.pop().printValue()
        }
    }
}