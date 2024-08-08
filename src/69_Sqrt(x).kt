package `69_Sqrt(x)`

class Solution {
    fun mySqrt(x: Int): Int {
        var left = 0
        var right = x
        var res = 0
        var n = 0
        while (left <= right) {
            n = (right - left) / 2 + left
            val n2 = n.toLong() * n
            when {
                n2 > x -> right = n
                n2 < x -> left = n
                else -> {
                    res = n
                    break
                }
            }
            if (res == n) {
                break
            }
            res = n
        }
        return res
    }
}

fun main() {
    val s = Solution()
    s.mySqrt(1).also { println(it) }
}