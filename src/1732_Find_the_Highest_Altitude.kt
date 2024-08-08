package `1732_Find_the_Highest_Altitude`

class Solution {
    fun largestAltitude(gain: IntArray): Int {
        var max = 0
        var sum = 0

        for (g in gain) {
            sum += g
            max = maxOf(sum, max)
        }

        return max
    }
}