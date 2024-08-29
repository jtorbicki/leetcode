package `46_Permutations`

//class Solution {
//    val list = mutableListOf<List<Int>>()
//
//    fun dfs(rest: IntArray, permutation: MutableList<Int>) {
//        if (rest.isEmpty()) {
//            list.add(permutation)
//        } else {
//            for (i in rest.indices) {
//                val dest = IntArray(rest.size - 1)
//                rest.copyInto(dest, 0, 0, i)
//                rest.copyInto(dest, i, i + 1)
//                val newList = mutableListOf(rest[i])
//                newList.addAll(permutation)
//                dfs(dest, newList)
//            }
//        }
//    }
//
//    fun permute(nums: IntArray): List<List<Int>> {
//        dfs(nums, mutableListOf())
//        return list
//    }
//}

//class Solution {
//
//    val perms = mutableListOf<List<Int>>()
//    val perm = mutableListOf<Int>()
//
//    private fun findPermutations(nums: MutableList<Int>) {
//        if (nums.isEmpty()) {
//            perms.add(ArrayList(perm))
//            return
//        }
//
//        for ((index, n) in nums.withIndex()) {
//            perm.add(n)
//            val copy = ArrayList(nums)
//            copy.removeAt(index)
//            findPermutations(copy)
//            perm.removeLast()
//        }
//    }
//
//    fun permute(nums: IntArray): List<List<Int>> {
//        findPermutations(nums.toMutableList())
//        return perms
//    }
//}

class Solution {


    fun permute(nums: IntArray): List<List<Int>> {

        val result = mutableListOf<List<Int>>()
        val elements = mutableListOf<Int>()

        fun bt(list: List<Int>) {
            if (elements.size == nums.size) {
                result.add(ArrayList(elements))
                return
            }

            for (i in 0..list.lastIndex) {
                val copy = list.toMutableList()
                copy.removeAt(i)
                elements.add(list[i])
                bt(copy)
                elements.removeLast()
            }
        }

        bt(nums.toList())
        return result
    }
}

fun main(args: Array<String>) {
    val solution = Solution()
    solution.permute(intArrayOf(1, 2, 3)).let(::println)
}
