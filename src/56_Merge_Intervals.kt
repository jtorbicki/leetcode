package `56_Merge_Intervals`

class Solution {
    fun merge(intervals: Array<IntArray>): Array<IntArray> {
        val starts = IntArray(10001)
        val ends = IntArray(10001)
        var lastIndex = 0

        for (interval in intervals) {
            val start = interval[0]
            val end = interval[1]
            starts[start] += 1
            ends[end] -= 1
            lastIndex = maxOf(lastIndex, end)
        }

        val result = mutableListOf<IntArray>()
        var startIndex = -1
        var sum = 0
        for (index in 0..lastIndex) {
            val start = starts[index]
            val end = ends[index]
            if (start != 0 || end != 0) {
                if (start != 0) {
                    if (startIndex < 0) {
                        startIndex = index
                    }
                    sum += start
                }
                if (end != 0) {
                    sum += end
                }
                if (sum == 0) {
                    result.add(intArrayOf(startIndex, index))
                    startIndex = -1
                }
            }
        }

        return result.toTypedArray()
    }
}

fun main() {
    val s = Solution()
    s.merge(arrayOf(intArrayOf(1,4), intArrayOf(4, 5)))
}