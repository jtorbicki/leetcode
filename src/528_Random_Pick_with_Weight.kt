package `528_Random_Pick_with_Weight`

import java.util.Random
import java.util.TreeMap

class Solution(w: IntArray) {

    val sum = w.sum()
    val tree = run {
        var index = 0
        val distribution = w.map { it / sum.toDouble() to index++ }
        val tree = TreeMap<Double, Int>()
        var sum = 0.0
        for ((prob, value) in distribution) {
            tree[sum] = value
            sum += prob
        }
        tree
    }

    val rand = Random(0)

    fun pickIndex(): Int {
        val value = rand.nextDouble()
        return tree.floorEntry(value).value
    }

}

fun main() {
    val s = Solution(intArrayOf(10, 7, 8, 10))
    s.pickIndex().also { println(it) }
    s.pickIndex().also { println(it) }
    s.pickIndex().also { println(it) }
    s.pickIndex().also { println(it) }
    s.pickIndex().also { println(it) }
}