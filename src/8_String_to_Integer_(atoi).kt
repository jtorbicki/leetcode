package `8_String_to_Integer_(atoi)`

import kotlin.math.min

class Solution {
    fun myAtoi(s: String): Int {
        var index = 0
        val size = s.length
        var output = 0L
        var sign = 1

        while (index < size && s[index] == ' ') {
            index++
        }
        if (index < size) {
            val first = s[index]
            when {
                first == '-' -> sign = -1
                first == '+' -> {}
                first.isDigit() -> index--
                else -> return output.toInt()
            }
            index++
            while (index < size && s[index] == '0') {
                index++
            }
            val begin = index
            while (index < size && s[index].isDigit()) {
                index++
            }
            var end = if (index == size) size - 1 else index - 1
            var multiplier = 1L
            while (end >= begin) {
                if (sign < 0 && (-output <= Int.MIN_VALUE || multiplier > Int.MAX_VALUE)) {
                    return Int.MIN_VALUE
                } else if (sign > 0 && (output >= Int.MAX_VALUE || multiplier > Int.MAX_VALUE)) {
                    return Int.MAX_VALUE
                }
                output += s[end].digitToInt() * multiplier
                if (sign < 0 && (-output <= Int.MIN_VALUE || multiplier > Int.MAX_VALUE)) {
                    return Int.MIN_VALUE
                } else if (sign > 0 && (output >= Int.MAX_VALUE || multiplier > Int.MAX_VALUE)) {
                    return Int.MAX_VALUE
                }
                multiplier *= 10
                end--
            }
        }

        return output.toInt() * sign
    }
}

fun main(args: Array<String>) {
    val s = Solution()
    s.myAtoi("2147483648").let { println(it) }
}