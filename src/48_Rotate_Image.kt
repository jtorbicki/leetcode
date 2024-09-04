package `48_Rotate_Image`

class Solution {
    fun rotate(matrix: Array<IntArray>): Unit {
        var tr = 0
        var br = matrix.lastIndex
        var lc = 0
        var rc = matrix[0].lastIndex

        fun rotateLine(tr: Int, br: Int, lc: Int, rc: Int) {
            for (i in 0..< (br - tr)) {
                val one = matrix[tr][lc + i]
                matrix[tr][lc + i] = matrix[br - i][lc]
                matrix[br - i][lc] = matrix[br][rc - i]
                matrix[br][rc - i] = matrix[tr + i][rc]
                matrix[tr + i][rc] = one
            }
        }

        while (tr < br) {
            rotateLine(tr, br, lc, rc)
            tr += 1
            br -= 1
            lc += 1
            rc -= 1
        }
    }
}

fun main() {
    val s = Solution()
    val matrix = arrayOf(
        intArrayOf(2,29,20,26,16,28),
        intArrayOf(12,27,9,25,13,21),
        intArrayOf(32,33,32,2,28,14),
        intArrayOf(13,14,32,27,22,26),
        intArrayOf(33,1,20,7,21,7),
        intArrayOf(4,24,1,6,32,34),
    )
    s.rotate(
        matrix
    )
    val a = 1
}