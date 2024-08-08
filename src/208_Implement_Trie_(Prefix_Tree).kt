package `208_Implement_Trie_(Prefix_Tree)`

data class Node(val c: Char? = null, val nodes: MutableMap<Char, Node> = mutableMapOf(), var end: Boolean = false) {

    fun insert(word: List<Char>) {
        if (word.isEmpty()) return
        val head = word.first()
        val node = nodes.getOrPut(head) {
            Node(c = head)
        }
        if (word.size == 1) {
            node.end = true
        } else {
            node.insert(word.subList(1, word.size))
        }
    }

    fun search(word: List<Char>): Boolean {
        if (word.isEmpty()) {
            return end
        }
        val head = word.first()
        val node = nodes[head]
        if (node != null) {
            return node.search(word.subList(1, word.size))
        }
        return false
    }

    fun startsWith(word: List<Char>): Boolean {
        if (word.isEmpty()) {
            return true
        }
        val head = word.first()
        val node = nodes[head]
        if (node != null) {
            return node.startsWith(word.subList(1, word.size))
        }
        return false
    }
}

class Trie {

    val root: Node = Node()

    fun insert(word: String) {
        root.insert(word.toList())
        val a = 1
    }

    fun search(word: String): Boolean {
        return root.search(word.toList())
    }

    fun startsWith(prefix: String): Boolean {
        return root.startsWith(prefix.toList())
    }

}

fun main(args: Array<String>) {
    val word = "apple"
    val obj = Trie()
    obj.insert(word)
    obj.insert("app")
    var param_2 = obj.search("app")
    var param_3 = obj.startsWith("app")
    val a = 1
}
