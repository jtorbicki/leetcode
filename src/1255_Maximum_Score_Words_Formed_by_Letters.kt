package `1255_Maximum_Score_Words_Formed_by_Letters`

class Solution {
    fun maxScoreWords(words: Array<String>, letters: CharArray, score: IntArray): Int {
        var max = 0
        var count = 0
        var frequency = IntArray(26)
        for (letter in letters) {
            frequency[letter - 'a'] += 1
        }

        fun includeWord(word: String, freq: IntArray): Int? {
            var result = 0
            for (c in word) {
                freq[c - 'a'] -= 1
                if (freq[c - 'a'] < 0) {
                    return null
                }
                result += score[c - 'a']
            }
            return result
        }

        fun excludeWord(word: String): Int {
            var result = 0
            for (c in word) {
                frequency[c - 'a'] += 1
                result += score[c - 'a']
            }
            return result
        }

        fun bt(index: Int) {
            if (index == words.size) {
                return
            }

            val word = words[index]
            val copy = frequency.copyOf()
            val include = includeWord(word, copy)
            if (include != null) {
                count += include
                frequency = copy
                max = maxOf(max, count)
                bt(index + 1)
                count -= excludeWord(word)

            }
            bt(index + 1)
        }

        bt(0)

        return max
    }
}

fun main() {
    val s = Solution()
    s.maxScoreWords(
        arrayOf("dog","cat","dad","good"),
        charArrayOf('a','a','c','d','d','d','g','o','o'),
        intArrayOf(1,0,9,5,0,0,3,0,0,0,0,0,0,0,2,0,0,0,0,0,0,0,0,0,0,0)
    ).also { println(it) }
}