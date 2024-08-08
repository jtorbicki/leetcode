package `11_Container_With_Most_Water`

class Solution {
    fun maxArea(height: IntArray): Int {
        var left = 0
        var right = height.size - 1
        var result = 0

        while (left < right) {
            val area = (right - left) * minOf(height[left], height[right])
            result = maxOf(result, area)
            when {
                height[left] > height[right] -> right--
                else -> left++
            }
        }

        return result
    }
}

fun main() {
    val solution = Solution()
    solution.maxArea(intArrayOf(1,8,6,2,5,4,8,3,7)).also { println(it) }
}