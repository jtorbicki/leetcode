package `1328_Break_a_Palindrome`

class Solution {
    fun breakPalindrome(palindrome: String): String {
        if (palindrome.length < 2)
            return ""

        val array = palindrome.toCharArray()

        for ((index, c) in array.withIndex()) {
            if (c != 'a') {
                array[index] = 'a'
                if (!(array contentEquals array.reversedArray())) {
                    return array.joinToString("")
                }
                array[index] = palindrome[index]
            }
        }

        array[array.lastIndex] = 'b'
        return array.joinToString("")
    }
}
