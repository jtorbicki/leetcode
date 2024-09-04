package `78_Subsets`

//class Solution {
//    fun subsets(nums: IntArray): List<List<Int>> {
//        val size = nums.size
//
//        val result = ArrayList<List<Int>>()
//
//        fun dfs(index: Int, arr: List<Int>) {
//            if (index == size) {
//                result.add(arr)
//                return
//            }
//
//            dfs(index + 1, arr)
//            val list =  arr.toMutableList() + nums[index]
//            dfs(index + 1, list)
//        }
//
//        dfs(0, emptyList())
//
//        return result
//    }
//}

class Solution {
    fun subsets(nums: IntArray): List<List<Int>> {
        val size = nums.size

        val result = ArrayList<List<Int>>()
        val arr = mutableListOf<Int>()

        fun dfs(index: Int) {
            if (index == size) {
                result.add(ArrayList(arr))
                return
            }

            dfs(index + 1)
            arr.add(nums[index])
            dfs(index + 1)
            arr.removeLast()
        }

        dfs(0)

        return result
    }
}


fun main(args: Array<String>) {
    val solution = Solution()
    solution.subsets(intArrayOf(1,2,3)).let { println(it) }
}
