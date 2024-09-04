package `322_Coin_Change`

class Solution {

    fun coinChange(coins: IntArray, amount: Int): Int {
        if (amount == 0)
            return 0

        val dp = IntArray(amount + 1) { amount + 1 }
        dp[0] = 0

        for (sum in 1..amount) {
            for (c in coins) {
                if (sum >= c) {
                    dp[sum] = minOf(dp[sum], dp[sum - c] + 1)
                }
            }
        }

        return if (dp[amount] != amount + 1) dp[amount] else -1
    }
}

fun main() {
    val s = Solution()
    s.coinChange(
        intArrayOf(2,5,10,1), 27
    ).also { println(it) }
}