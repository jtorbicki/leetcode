package `169_Majority_Element`

class Solution {
    fun majorityElement(nums: IntArray): Int {
        var major: Int? = null
        var counter = 0

        for (n in nums) {
            when {
                major == null -> {
                    major = n
                    counter++
                }
                n == major -> counter++
                n != major -> {
                    counter--
                    if (counter == 0) {
                        major = null
                    }
                }
            }
        }

        return major!!
    }
}

fun main() {
    val solution = Solution()
    solution.majorityElement(intArrayOf(2,2,1,1,1,2,2)).also { println(it) }
}