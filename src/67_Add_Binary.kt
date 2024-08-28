class `67_Add_Binary`

class Solution {
    fun addBinary(a: String, b: String): String {
        var index1 = a.lastIndex
        var index2 = b.lastIndex
        var over = 0
        val sum = ArrayList<Char>()

        while (index1 >= 0 || index2 >= 0) {
            val num1 = if (index1 >= 0) a[index1].digitToInt() else 0
            val num2 = if (index2 >= 0) b[index2].digitToInt() else 0

            when (num1 + num2 + over) {
                0 -> sum.add('0')
                1 -> {
                    sum.add('1')
                    over = 0
                }
                2 -> {
                    sum.add('0')
                    over = 1
                }
                3 -> {
                    sum.add('1')
                    over = 1
                }
            }
            index1--
            index2--
        }
        if (over == 1) {
            sum.add('1')
        }
        return sum.joinToString("").reversed()
    }
}

fun main() {
    val s = Solution()
    s.addBinary("101", "111").also { println(it) }
}