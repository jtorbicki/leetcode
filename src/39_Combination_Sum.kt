package `39_Combination_Sum`

import java.util.LinkedList

class Solution {
    fun combinationSum(candidates: IntArray, target: Int): List<List<Int>> {

        candidates.sort()

        val numbers = LinkedList<Int>()
        val result = mutableSetOf<List<Int>>()

        fun bt(sum: Int): Boolean {
            when {
                sum == target -> {
                    val list = ArrayList(numbers)
                    list.sort()
                    result.add(list)
                    return true
                }
                sum > target -> return true
            }

            for (c in candidates) {
                numbers.add(c)
                val shouldBreak = bt(sum + c)
                numbers.removeLast()
                if (shouldBreak) {
                    break
                }
            }

            return false
        }

        bt(0)

        return result.toList()
    }
}

fun main() {
    val s = Solution()
    s.combinationSum(intArrayOf(2,3,6,7), 7)
}
