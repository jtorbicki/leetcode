package `134_Gas_Station`

class Solution {
    fun canCompleteCircuit(gas: IntArray, cost: IntArray): Int {
        if (gas.sum() < cost.sum()) {
            return -1
        }

        val diff = gas.mapIndexed { i, v -> v - cost[i] }

        var total = 0
        var result = -1
        for (i in 0..diff.lastIndex) {
            total += diff[i]
            if (total < 0) {
                total = 0
                result = -1
                continue
            } else if (result == -1) {
                result = i
            }
        }
        return result
    }
}


fun main() {
    val s = Solution()
    s.canCompleteCircuit(intArrayOf(1,2,3,4,5), intArrayOf(3,4,5,1,2)).also { println(it) }
}