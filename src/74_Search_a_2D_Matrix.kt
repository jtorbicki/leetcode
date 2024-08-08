package `74_Search_a_2D_Matrix`

class Solution {
    fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
        val array = matrix.fold(ArrayList<Int>()) { acc, it: IntArray ->
            acc.addAll(it.toTypedArray())
            acc
        }
        return array.binarySearch(target) >= 0
    }
}
