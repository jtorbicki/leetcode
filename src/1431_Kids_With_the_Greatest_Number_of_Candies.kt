package `1431_Kids_With_the_Greatest_Number_of_Candies`

class Solution {
    fun kidsWithCandies(candies: IntArray, extraCandies: Int): List<Boolean> {
        val max = candies.max()
        return candies.map { it + extraCandies >= max }
    }
}
