package `242_Valid_Anagram`

class Solution {
    fun isAnagram(s: String, t: String): Boolean {
        if (s.length != t.length) return false
        val arr1 = s.toCharArray()
        val arr2 = t.toCharArray()
        arr1.sort()
        arr2.sort()
        return arr1 contentEquals arr2
    }
}