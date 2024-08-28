package `190_Reverse_Bits`

class Solution {
    fun reverseBits(n: Int): Int {
        var result = 0
        var num = n
        for (i in 0 until 32) {
            result = result shl 1
            result = result or (num and 1)
            num = num shr 1
        }
        return result
    }
}

fun main() {
    val s = Solution()
    s.reverseBits("1111111111111111111111111111101".toInt(2)).also { println(it.toString(2)) }
}

