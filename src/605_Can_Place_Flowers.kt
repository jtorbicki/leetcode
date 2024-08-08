package `605_Can_Place_Flowers`

class Solution {
    fun canPlaceFlowers(flowerbed: IntArray, n: Int): Boolean {
        var count = 0
        when {
            flowerbed.size >= 3 -> {
                for (i in 0..flowerbed.lastIndex) {
                    val first = if (i == 0) 0 else flowerbed[i - 1]
                    val last = if (i == flowerbed.lastIndex) 0 else flowerbed[i + 1]
                    if (first == 0 && flowerbed[i] == 0 && last == 0) {
                        count++
                        flowerbed[i] = 1
                    }
                }
            }
            flowerbed.size == 2 -> count = if (flowerbed[0] == 0 && flowerbed[1] == 0) 1 else 0
            flowerbed.size == 1 -> count = if (flowerbed[0] == 0) 1 else 0
        }
        return count >= n
    }
}

fun main() {
    val solution = Solution()
    solution.canPlaceFlowers(intArrayOf(1,0,0,0,1,0,0), 2).also(::println)
}
