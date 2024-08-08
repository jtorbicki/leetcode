package `409_Longest_Palindrome`

//class Solution {
//    fun longestPalindrome(s: String): Int {
//        val map = mutableMapOf<Char, Int>()
//        s.toCharArray().forEach {
//            map[it] = map.getOrDefault(it, 0) + 1
//        }
//        var pairs = 0
//        var single = false
//        map.values.forEach {
//            pairs += it / 2
//            if (it % 2 != 0) {
//                single = true
//            }
//        }
//        return pairs * 2 + if (single) 1 else 0
//    }
//}


class Solution {
    fun longestPalindrome(s: String): Int {
        val map = s.groupingBy { it }.eachCount()

        var pairs = 0
        var single = false
        map.values.forEach {
            pairs += it / 2
            if (it % 2 != 0) {
                single = true
            }
        }
        return pairs * 2 + if (single) 1 else 0
    }
}


fun main(args: Array<String>) {
    val solution = Solution()
    solution.longestPalindrome("abccccdd").let(::println)
}