package `1441_Build_an_Array_With_Stack_Operations`

class Solution {
    fun buildArray(target: IntArray, n: Int): List<String> {
        val result = mutableListOf<String>()

        var index = 1
        var counter = 1
        while (counter <= n && index <= target.size) {
            when (target[index - 1] == counter) {
                true -> {
                    result += "Push"
                    index += 1
                }
                else -> result += listOf("Push", "Pop")
            }
            counter += 1
        }
        return result
    }
}

fun main() {
    val s = Solution()
    s.buildArray(intArrayOf(1, 3), 3)
}