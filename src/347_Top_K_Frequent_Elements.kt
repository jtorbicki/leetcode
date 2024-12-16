package `347_Top_K_Frequent_Elements`

import java.util.PriorityQueue

class Solution {

    data class NumCount(val num: Int, var count: Int)

    fun topKFrequent(nums: IntArray, k: Int): IntArray {
        val heap = PriorityQueue<NumCount>({
            n1, n2 -> n2.count - n1.count
        })

        val map = mutableMapOf<Int, NumCount>()

        for (n in nums) {
            map[n] = map.getOrDefault(n, NumCount(n, 0)).also { it.count + 1 }
        }

        heap.addAll(map.values)

        val result = mutableListOf<Int>()
        repeat(k) {
            result += heap.poll().num
        }

        return result.toIntArray()
    }
}

fun main() {
    val s = Solution()
    s.topKFrequent(intArrayOf(3, 0, 1, 0), 1).also { print(it.contentToString()) }
}