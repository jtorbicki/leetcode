package `43_Multiply_Strings`

class Solution {
    fun multiply(num1: String, num2: String): String {
        if (num1 == "0" || num2 == "0") return "0"

        val result = IntArray(num1.length + num2.length)

        for (i in num1.indices.reversed()) {
            for (j in num2.indices.reversed()) {
                val mul = (num1[i] - '0') * (num2[j] - '0')
                val sum = mul + result[i + j + 1]

                result[i + j + 1] = sum % 10
                result[i + j] += sum / 10
            }
        }

        val sb = StringBuilder()
        for (r in result) {
            if (!(sb.isEmpty() && r == 0)) {
                sb.append(r)
            }
        }

        return if (sb.isEmpty()) "0" else sb.toString()
    }
}

fun main() {
    val s = Solution()
    s.multiply("123", "456").also { println(it) }
}