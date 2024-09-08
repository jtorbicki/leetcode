package `7_Reverse_Integer`

class Solution {
    fun reverse(x: Int): Int {
        if (x == Int.MIN_VALUE)
            return 0

        var value = x
        var result = 0L
        while (value != 0) {
            result *= 10
            val rest = value % 10
            result += rest
            value /= 10
        }
        return if (result !in Int.MIN_VALUE..Int.MAX_VALUE) 0 else result.toInt()
    }
}

fun main() {
    val s = Solution()
    s.reverse(-1563847412).also { println(it) }
}