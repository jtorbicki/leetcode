package `443_String_Compression`

class Solution {
    fun compress(chars: CharArray): Int {
        if (chars.size < 2) return chars.size

        var readIndex = 0
        var writeIndex = 0

        fun write(num: Int, c: Char) {
            chars[writeIndex++] = c
            if (num > 1) {
                val str = num.toString()
                str.toCharArray().copyInto(chars, writeIndex)
                writeIndex += str.length
            }
        }

        for (index in 1.. chars.lastIndex) {
            if (chars[index] != chars[index - 1]) {
                write(index - readIndex, chars[index - 1])
                readIndex = index
            }
            if (index == chars.lastIndex) {
                write(index - readIndex + 1, chars[index])
            }
        }
        return writeIndex
    }
}

fun main(args: Array<String>) {
    val solution = Solution()
    solution.compress(charArrayOf('a','b','c')).also { println(it) }
}

// [a, b, c]
// [d, e, f]

