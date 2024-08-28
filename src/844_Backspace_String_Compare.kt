package `844_Backspace_String_Compare`

class Solution {
    fun backspaceCompare(s: String, t: String): Boolean {
        var i = s.length - 1
        var j = t.length - 1

        while (i >= 0 || j >= 0) {
            var skipS = 0
            while (i >= 0) {
                if (s[i] == '#') {
                    skipS++
                    i--
                } else if (skipS > 0) {
                    skipS--
                    i--
                } else {
                    break
                }
            }

            var skipT = 0
            while (j >= 0) {
                if (t[j] == '#') {
                    skipT++
                    j--
                } else if (skipT > 0) {
                    skipT--
                    j--
                } else {
                    break
                }
            }

            if (i >= 0 && j >= 0 && s[i] != t[j]) {
                return false
            }

            if ((i >= 0) != (j >= 0)) {
                return false
            }

            i--
            j--
        }

        return true
    }
}

fun main() {
    val s = Solution()
    s.backspaceCompare("ab#c","ad#c").also { println(it) }
}
