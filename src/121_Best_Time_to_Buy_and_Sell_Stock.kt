package `121_Best_Time_to_Buy_and_Sell_Stock`

import kotlin.math.max

class Solution {
    fun maxProfit(prices: IntArray): Int {
        var profit = 0
        var buy = prices[0]
        for (i in 1 until prices.size) {
            val sell = prices[i]
            if (sell < buy) {
                buy = sell
            } else {
                profit = max(profit, sell - buy)
            }
        }
        return profit
    }
}

fun main() {
    val solution = Solution()
    println(solution.maxProfit(intArrayOf(7,1,5,3,6,4)))
}
