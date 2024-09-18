package `3263_Convert_Doubly_Linked_List_to_Array_I`

class Node(var `val`: Int) {
    var prev: Node? = null
    var next: Node? = null
}


class Solution {
    fun toArray(root: Node?): IntArray {
        if (root == null)
            return intArrayOf()

        val list = mutableListOf<Int>()

        var current = root
        while (current != null) {
            list.add(current.`val`)
            current = current.next
        }

        return list.toIntArray()
    }
}