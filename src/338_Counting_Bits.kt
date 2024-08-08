package `338_Counting_Bits`

class Solution {
    fun countBits(n: Int): IntArray {
        val out = IntArray(maxOf(n + 1, 4))

        out[0] = 0
        out[1] = 1
        out[2] = 1
        out[3] = 2

        var offset = 0
        var maxOffset = 4
        for (i in 4.. n) {
            out[i] = 1 + out[offset++]
            if (offset == maxOffset) {
                offset = 0
                maxOffset *= 2
            }
        }

        return out.copyOf(n + 1)
    }
}

fun main() {
    val solution = Solution()
    solution.countBits(1).also { println(it.contentToString()) }
}