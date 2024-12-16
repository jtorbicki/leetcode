package `77_Combinations`

class Solution {
    fun combine(n: Int, k: Int): List<List<Int>> {
        val result = mutableListOf<List<Int>>()

        val current = mutableListOf<Int>()

        fun bt(index: Int) {
            if (current.size == k) {
                result.add(ArrayList(current))
            } else {
                for (i in index + 1..n) {
                    current.add(i)
                    bt(i)
                    current.removeLast()
                }
            }
        }

        bt(0)

        return result
    }
}

fun main() {
    val s = Solution()
    s.combine(4, 2).also { println(it) }
}