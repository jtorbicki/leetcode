package `50_Pow(x,_n)`

class Solution {
    fun myPow(x: Double, n: Int): Double {
        var x = x
        var ans = 1.0
        var nTemp = n.toLong()

        if (n < 0) nTemp = nTemp * -1

        while (nTemp > 0) {
            if (nTemp % 2 == 0L) {
                x *= x
                nTemp /= 2
            } else {
                ans *= x
                nTemp--
            }
        }
        return if (n < 0) 1 / ans else ans
    }
}

fun main() {
    val s = Solution()
    s.myPow(2.0, -2).also { println(it) }
}