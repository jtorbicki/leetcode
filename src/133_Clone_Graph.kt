package `133_Clone_Graph`

import kotlin.collections.ArrayList

class Node(var `val`: Int) {
    var neighbors: ArrayList<Node?> = ArrayList<Node?>()
}


class Solution {

    private val cache = mutableMapOf<Int, Node>()

    private fun clone(node: Node?): Node? {
        if (node == null)
            return null

        val cloned = cache.getOrPut(node.`val`) {
            Node(node.`val`)
        }
        for (n in node.neighbors) {
            if (n != null) {
                val cn = cache.getOrPut(n.`val`) {
                    clone(n)!!
                }
                cloned.neighbors.add(cn)
            }
        }
        return cloned
    }

    fun cloneGraph(node: Node?): Node? {
        return clone(node)
    }
}

fun main() {
    val s = Solution()
    val graph = Node(1)
    val list = ArrayList<Node?>()
    list.add(Node(2))
    list.add(Node(4))
    graph.neighbors = list
    list[0]!!.neighbors = list
    s.cloneGraph(graph)
}
