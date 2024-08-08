package `122_Best_Time_to_Buy_and_Sell_Stock_II`

class Solution {
    fun maxProfit(prices: IntArray): Int {
        var profit = 0
        for (i in 1..prices.lastIndex) {
            if (prices[i] > prices[i-1]) {
                profit += prices[i] - prices[i-1]
            }
        }
        return profit
    }
}
