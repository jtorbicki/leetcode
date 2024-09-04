package `91_Decode_Ways`

class Solution {
    fun numDecodings(s: String): Int {

        val cache = IntArray(101) { -1 }

        fun bt(index: Int): Int {
            if (cache[index] >= 0) {
                return cache[index]
            }

            if (index == s.length) {
                return 1
            }

            var decoded = 0
            if (s[index] != '0') {
                decoded += bt(index + 1)
                if (index <= s.length - 2) {
                    val number = s.substring(index, index + 2).toInt()
                    if (number <= 26) {
                        decoded += bt(index + 2)
                    }
                }
            }

            cache[index] = decoded

            return decoded
        }

        return bt(0)
    }
}

fun main() {
    val s = Solution()
    s.numDecodings("226").also { println(it) }
}