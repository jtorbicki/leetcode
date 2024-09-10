package `138_Copy_List_with_Random_Pointer`

class Node(var `val`: Int) {
    var next: Node? = null
    var random: Node? = null
}

class Solution {

    val cache = mutableMapOf<Node, Node>()

    fun copyRandomList(node: Node?): Node? {
        val holder = Node(0)
        var pointer: Node? = node
        var copyPointer: Node? = holder

        while (pointer != null) {
            val copy = Node(pointer.`val`)
            cache[pointer] = copy
            copyPointer!!.next = copy
            copyPointer = copy
            pointer = pointer.next
        }

        pointer = node
        copyPointer = holder.next

        while (pointer != null) {
            val cached = cache[pointer.random]
            copyPointer!!.random = cached
            pointer = pointer.next
            copyPointer = copyPointer.next
        }

        return holder.next
    }
}

fun main() {
    val s = Solution()
    val list = Node(3)
    list.next = Node(2)
    list.next!!.next = Node(3)
    s.copyRandomList(list)
}