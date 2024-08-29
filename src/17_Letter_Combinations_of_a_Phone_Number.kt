package `17_Letter_Combinations_of_a_Phone_Number`

class Solution {
    fun letterCombinations(digits: String): List<String> {
        val result = mutableListOf<String>()

        val map = mapOf(
            '2' to "abc",
            '3' to "def",
            '4' to "ghi",
            '5' to "jkl",
            '6' to "mno",
            '7' to "pqrs",
            '8' to "tuv",
            '9' to "wxyz"
        )

        fun backtrack(str: String, index: Int) {
            if (str.length == digits.length) {
                result.add(str)
                return
            }

            val digit = digits[index]
            for (c in map[digit]!!) {
                backtrack(str + c, index + 1)
            }
        }

        if (digits == "") return result
        backtrack("", 0)
        return result
    }
}

fun main(args: Array<String>) {
    val solution = Solution()
    solution.letterCombinations("23").also { println(it) }
}