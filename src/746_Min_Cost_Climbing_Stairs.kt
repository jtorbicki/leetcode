package `746_Min_Cost_Climbing_Stairs`

class Solution {
    fun minCostClimbingStairs(cost: IntArray): Int {
        for (i in cost.size - 3 downTo 0) {
            cost[i] += minOf(cost[i + 1], cost[i + 2])
        }
        return minOf(cost[0], cost[1])
    }
}

fun main() {
    val solution = Solution()
    solution.minCostClimbingStairs(intArrayOf(1,100,1,1,1,100,1,1,100,1)).also(::println)
}