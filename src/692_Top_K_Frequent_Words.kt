package `692_Top_K_Frequent_Words`

import java.util.*

class Solution {

    data class WordAmount(val word: String, val amount: Int)

    fun topKFrequent(words: Array<String>, k: Int): List<String> {
        val heap = PriorityQueue(Comparator<WordAmount> { w1, w2 ->
            (w2.amount - w1.amount).takeIf { it != 0 } ?: (w1.word compareTo w2.word)
        })

        val group = words.groupingBy { it }.eachCount()

        heap.addAll(group.map { (word, amount) -> WordAmount(word, amount) })

        val result = mutableListOf<String>()

        repeat(k) {
            result.add(heap.remove().word)
        }

        return result
    }
}