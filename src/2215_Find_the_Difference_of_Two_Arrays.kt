package `2215_Find_the_Difference_of_Two_Arrays`

import java.util.*

class Solution {
    fun findDifference(nums1: IntArray, nums2: IntArray): List<List<Int>> {
        val tree1 = TreeSet<Int>()
        val tree2 = TreeSet<Int>()
        val tree3 = TreeSet<Int>()
        val tree4 = TreeSet<Int>()
        tree1.addAll(nums1.asSequence())
        tree3.addAll(nums1.asSequence())
        tree2.addAll(nums2.asSequence())
        tree4.addAll(nums2.asSequence())

        return listOf((tree1 - tree2).toList(), (tree4 - tree3).toList())
    }
}

fun main(args: Array<String>) {
    val solution = Solution()
    solution.findDifference(listOf(1, 2, 3, 3).toIntArray(), listOf(1, 1, 2, 2).toIntArray())
}