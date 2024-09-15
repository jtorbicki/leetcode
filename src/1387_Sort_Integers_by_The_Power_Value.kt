package `1387_Sort_Integers_by_The_Power_Value`

import java.util.PriorityQueue

class Solution {
    fun getKth(lo: Int, hi: Int, k: Int): Int {

        val cache = IntArray(20000)

//        fun calculate(num: Int): Int {
//            var i = 0
//            var result = num
//
//            while (result > 1) {
//                result = when (result % 2) {
//                    0 -> result / 2
//                    else -> 3 * result + 1
//                }
//                i += 1
//            }
//            return i
//        }

        fun calculate(num: Int): Int {
            if (num <= 2) return num - 1

            if (cache[num] > 0)
                return cache[num]

            val next = when (num % 2) {
                0 -> num / 2
                else -> 3 * num + 1
            }

            val value = 1 + calculate(next)
            cache[num] = value
            return value
        }


        val heap = PriorityQueue(Comparator<Pair<Int, Int>> { v1, v2 ->
            when {
                v1.second != v2.second -> v1.second - v2.second
                else -> v1.first - v2.first
            }

        })

        for (n in lo..hi) {
            heap.add(n to calculate(n))
        }

        var result = 0
        repeat(k) {
            result = heap.poll().first
        }

        return result
    }
}

fun main() {
    val s = Solution()
    s.getKth(10, 20, 5).also { println(it) }
}