package `643_Maximum_Average_Subarray_I`

class Solution {
    fun findMaxAverage(nums: IntArray, k: Int): Double {
        if (nums.size == 1)
            return nums[0].toDouble()
        var max = 0L
        var last = 0L

        for (i in 0..<k) {
            last += nums[i]
        }

        max = last

        for (i in 1.. nums.size - k) {
            last = last - nums[i - 1] + nums[i + k - 1]
            max = maxOf(last, max)
        }
        return max / k.toDouble()
    }
}

fun main(args: Array<String>) {
    val solution = Solution()
//    solution.findMaxAverage(intArrayOf(8860,-853,6534,4477,-4589,8646,-6155,-5577,-1656,-5779,-2619,-8604,-1358,-8009,4983,7063,3104,-1560,4080,2763,5616,-2375,2848,1394,-7173,-5225,-8244,-809,8025,-4072,-4391,-9579,1407,6700,2421,-6685,5481,-1732,-8892,-6645,3077,3287,-4149,8701,-4393,-9070,-1777,2237,-3253,-506,-4931,-7366,-8132,5406,-6300,-275,-1908,67,3569,1433,-7262,-437,8303,4498,-379,3054,-6285,4203,6908,4433,3077,2288,9733,-8067,3007,9725,9669,1362,-2561,-4225,5442,-9006,-429,160,-9234,-4444,3586,-5711,-9506,-79,-4418,-4348,-5891), 93).also(::println)
    solution.findMaxAverage(intArrayOf(1,12,-5,-6,50,3), 4).also(::println)
}