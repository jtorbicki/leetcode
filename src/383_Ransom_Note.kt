package `383_Ransom_Note`

class Solution {
    fun canConstruct(ransomNote: String, magazine: String): Boolean {
        val indexed = magazine.groupingBy { it }.eachCount() as MutableMap<Char, Int>
        for (c in ransomNote) {
            val number = indexed[c] ?: 0
            if (number > 0) {
                indexed[c] = number - 1
            } else {
                return false
            }
        }
        return true
    }
}

// ransomNote = "show me the money", magazine = "this is a magazine"