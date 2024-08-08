package `46_Permutations`

class Solution {
    val list = mutableListOf<List<Int>>()

    fun dfs(rest: IntArray, permutation: MutableList<Int>) {
        if (rest.isEmpty()) {
            list.add(permutation)
        } else {
            for (i in rest.indices) {
                val dest = IntArray(rest.size - 1)
                rest.copyInto(dest, 0, 0, i)
                rest.copyInto(dest, i, i + 1)
                val newList = mutableListOf(rest[i])
                newList.addAll(permutation)
                dfs(dest, newList)
            }
        }
    }

    fun permute(nums: IntArray): List<List<Int>> {
        dfs(nums, mutableListOf())
        return list
    }
}

fun main(args: Array<String>) {
    val solution = Solution()
    solution.permute(intArrayOf(1, 2, 3)).let(::println)
}