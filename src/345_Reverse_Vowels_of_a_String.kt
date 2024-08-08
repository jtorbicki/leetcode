package `345_Reverse_Vowels_of_a_String`

class Solution {
    fun reverseVowels(s: String): String {
        var left = 0
        var right = s.lastIndex
        val newString = s.toCharArray()

        val vowels = setOf('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U')

        while (true) {
            while (left < right && s[left] !in vowels) left++;
            while (left < right && s[right] !in vowels) right--;

            if (left >= right)
                break

            newString[left] = s[right]
            newString[right] = s[left]
            left++
            right--
        }

        return newString.joinToString("")
    }
}

fun main(args: Array<String>) {
    val s = Solution().reverseVowels("hello").also (::println)
}