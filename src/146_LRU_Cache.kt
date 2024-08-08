package `146_LRU_Cache`


class LRUCache(capacity: Int) {

    val cap = capacity
    val map = mutableMapOf<Int, Int>()
    val order = LinkedHashSet<Int>()

    fun get(key: Int): Int {
        return map[key]?.also {
            order.remove(key)
            order.add(key)
        } ?: -1
    }

    fun put(key: Int, value: Int) {
        val size = map.keys.size
        if (size >= cap) {
            if (!map.containsKey(key)) {
                val first = order.first()
                order.remove(first)
                map.remove(first)
            }
        }
        map[key] = value
        order.remove(key)
        order.add(key)
    }
}


fun main(args: Array<String>) {
    val lRUCache = LRUCache(2)
    lRUCache.put(1, 1) // cache is {1=1, 2=2}
    lRUCache.put(2, 2) // cache is {1=1, 2=2}
    val a = lRUCache.get(1)
    lRUCache.put(3, 3) // cache is {1=1, 2=2}
    val b = lRUCache.get(2)
    lRUCache.put(4, 4) // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
    val c = lRUCache.get(1)    // returns -1 (not found)
    val d = lRUCache.get(3)    // returns -1 (not found)
    val e = lRUCache.get(4)    // returns -1 (not found)
    val f = 1
}