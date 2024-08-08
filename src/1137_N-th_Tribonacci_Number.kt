package `1137_N-th_Tribonacci_Number`

class Solution {
    fun tribonacci(n: Int): Int {
        val array = IntArray(n + 3)
        array[0] = 0
        array[1] = 1
        array[2] = 1

        if (n >= 3) {
            for (i in 3..n) {
                array[i] = array[i - 1] + array[i - 2] + array[i - 3]
            }
        }

        return array[n]
    }
}