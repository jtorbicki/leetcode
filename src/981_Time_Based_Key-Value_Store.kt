package `981_Time_Based_Key-Value_Store`

import java.util.*
//
//class TimeMap {
//
//    private val map = mutableMapOf<String, TreeMap<Int, String>>()
//
//    fun set(key: String, value: String, timestamp: Int) {
//        map.computeIfAbsent(key) { TreeMap() }[timestamp] = value
//    }
//
//    fun get(key: String, timestamp: Int): String {
//        val tree = map[key] ?: return ""
//        if (timestamp > tree.keys.last()) {
//            return tree.values.last()
//        }
//        val keys = tree.keys.toTypedArray<Int>()
//        var left = 0
//        var right = keys.size - 1
//
//        while (left <= right) {
//            val mid = left + ((right - left) / 2)
//            when {
//                timestamp > keys[mid] -> left = mid + 1
//                timestamp == keys[mid] -> return tree[timestamp]!!
//                timestamp < keys[mid] -> right = mid - 1
//            }
//        }
//
//        if (right < 0) {
//            return ""
//        }
//        return tree[keys[right]] ?: ""
//    }
//}


class TimeMap {

    private val map = mutableMapOf<String, TreeMap<Int, String>>()

    fun set(key: String, value: String, timestamp: Int) {
        if (!map.containsKey(key)) {
            map[key] = TreeMap()
        }
        map.get(key)!![timestamp] = value
    }

    fun get(key: String, timestamp: Int): String {
        val tree = map[key] ?: return ""
        if (timestamp > tree.keys.last()) {
            return tree.values.last()
        }
        val key: Int = tree.floorKey(timestamp) ?: return ""
        return tree.get(key) ?: ""
    }
}


fun main(args: Array<String>) {
    val timeMap = TimeMap()
    timeMap.set("love", "high", 10)
    timeMap.set("love", "low", 20)
    val a = timeMap.get("love", 5)
    val b = timeMap.get("love", 10)
    val c = timeMap.get("love", 15)
    val d = timeMap.get("love", 20)
    val e = timeMap.get("love", 25)
    val z = 1
}