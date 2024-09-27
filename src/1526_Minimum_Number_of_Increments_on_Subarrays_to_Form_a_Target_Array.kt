package `1526_Minimum_Number_of_Increments_on_Subarrays_to_Form_a_Target_Array`

class Solution {
    fun minNumberOperations(target: IntArray): Int {
        var result = 0
        var prev = 0

        for (num in target) {
            if (num > prev) {
                result += (num - prev)
            }
            prev = num
        }
        return result
    }
}