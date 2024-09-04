package `658_Find_K_Closest_Elements`

import java.util.PriorityQueue
import kotlin.math.abs

class Solution {
    fun findClosestElements(arr: IntArray, k: Int, x: Int): List<Int> {
        val a = arr.sortedWith { v1, v2 ->
            abs(v1 - x) - abs(v2 - x)
        }

        return a.subList(0, k).sorted()
    }
}

fun main() {
    val s = Solution()
    s.findClosestElements(intArrayOf(0,0,1,2,3,3,4,7,7,8), 3, 5).also { println(it) }
}
