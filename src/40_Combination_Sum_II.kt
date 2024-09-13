package `40_Combination_Sum_II`

class Solution {
    fun combinationSum2(candidates: IntArray, target: Int): List<List<Int>> {
        candidates.sort()

        val result = mutableListOf<List<Int>>()
        val list = mutableListOf<Int>()

        fun bt(index: Int, sum: Int): Boolean {
            if (sum == target) {
                result.add(ArrayList(list))
                return true
            } else if (sum > target || index == candidates.size) {
                return true
            }

            list.add(candidates[index])
            bt(index + 1, sum + candidates[index])
            list.removeLast()
            var skip = index
            while (skip + 1 <= candidates.lastIndex && candidates[skip] == candidates[skip + 1])
                skip += 1
            bt(skip + 1, sum)

            return false
        }

        bt(0, 0)

        return result
    }
}

fun main() {
    val s = Solution()
    s.combinationSum2(intArrayOf(10,1,2,7,6,1,5), 8).also { println(it) }
}