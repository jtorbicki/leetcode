package `853_Car_Fleet`

class Solution {
    fun carFleet(target: Int, position: IntArray, speed: IntArray): Int {
        val cars = position.indices.map { index -> Pair(position[index], speed[index]) }.sortedByDescending { it.first }
        var fleets = 0
        var maxTime = 0.0
        for (car in cars) {
            val time = (target - car.first).toDouble() / car.second
            if (time > maxTime) {
                maxTime = time
                fleets++
            }
        }
        return fleets
    }
}

fun main() {
    val s = Solution()
    s.carFleet(12, intArrayOf(10, 8, 0, 5, 3), intArrayOf(2, 4, 1, 1, 3)).also { println(it) }
}