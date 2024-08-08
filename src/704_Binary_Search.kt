package `704_Binary_Search`

class Solution {
    fun search(nums: IntArray, target: Int): Int {
        var lowIndex = 0
        var highIndex = nums.size - 1
        while (lowIndex <= highIndex) {
            val index = lowIndex + (highIndex - lowIndex) / 2
            when {
                nums[index] == target -> return index
                nums[index] > target -> highIndex = index - 1
                nums[index] < target -> lowIndex = index + 1
            }
        }
        return -1
    }
}

fun main(args: Array<String>) {
    println(Solution().search(intArrayOf(-1,0,3,5,9,12), -12))
}
