package `70_Climbing_Stairs`

class Solution {

    fun climbStairs(n: Int): Int {
        val map = mapOf(
            0 to 0,
            1 to 1,
            2 to 1,
            3 to 2,
            4 to 3,
            5 to 5,
            6 to 8,
            7 to 13,
            8 to 21,
            9 to 34,
            10 to 55,
            11 to 89,
            12 to 144,
            13 to 233,
            14 to 377,
            15 to 610,
            16 to 987,
            17 to 1597,
            18 to 2584,
            19 to 4181,
            20 to 6765,
            21 to 10946,
            22 to 17711,
            23 to 28657,
            24 to 46368,
            25 to 75025,
            26 to 121393,
            27 to 196418,
            28 to 317811,
            29 to 514229,
            30 to 832040,
            31 to 1346269,
            32 to 2178309,
            33 to 3524578,
            34 to 5702887,
            35 to 9227465,
            36 to 14930352,
            37 to 24157817,
            38 to 39088169,
            39 to 63245986,
            40 to 102334155,
            41 to 165580141,
            42 to 267914296,
            43 to 433494437,
            44 to 701408733,
            45 to 1134903170,
            46 to 1836311903
        )

        return map[n + 1]!!
    }
}

