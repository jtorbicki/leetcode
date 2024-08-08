package `88_Merge_Sorted_Array`

class Solution {
    fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int): Unit {
        var write = m + n - 1
        var read1 = m - 1
        var read2 = n - 1
        while (write >= 0) {
            nums1[write] = when {
                read1 >= 0 && read2 >= 0 -> {
                    if (nums1[read1] > nums2[read2]) {
                        nums1[read1--]
                    } else {
                        nums2[read2--]
                    }
                }
                read1 >= 0 -> nums1[read1--]
                else ->  nums2[read2--]
            }
            write--
        }
    }
}

fun main() {
    val solution = Solution()
    val a = intArrayOf(1, 2, 3, 0, 0, 0)
    solution.merge(a, 3, intArrayOf(2, 5, 6), 3)
    println(a.contentToString())
}