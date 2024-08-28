package `191_Number_of_1_Bits`

class Solution {
    fun hammingWeight(n: Int): Int {
        var count = 0
        var num = n

        while (num > 0) {
            if (num % 2 > 0) {
                count += 1
            }
            num /= 2
        }

        return count
    }
}
