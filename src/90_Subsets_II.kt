package `90_Subsets_II`

class Solution {
    fun subsetsWithDup(nums: IntArray): List<List<Int>> {
        val result = mutableListOf<List<Int>>()
        nums.sort()
        val tempList = mutableListOf<Int>()

        fun backtrack(start: Int) {
            result.add(ArrayList(tempList))
            for (i in start until nums.size) {
                if (i > start && nums[i] == nums[i - 1])
                    continue
                tempList.add(nums[i])
                backtrack(i + 1)
                tempList.removeAt(tempList.size - 1)
            }
        }

        backtrack(0)
        return result
    }

}

fun main() {
    val s = Solution()
    s.subsetsWithDup(intArrayOf(1, 2, 2)).also { println(it) }
}

// [1, 2, 2]
// [[],[1],[1,2],[1,2,2],[2],[2,2]]
