package `71_Simplify_Path`

import java.util.LinkedList

class Solution {
    fun simplifyPath(path: String): String {
        val stack = LinkedList<String>()
        val paths = path.split("/")
        for (p in paths) {
            when(p) {
                ".." -> if (stack.isNotEmpty()) {
                    stack.removeLast()
                }
                ".", "" -> {}
                else -> stack.add(p)
            }
        }
        return "/" + stack.joinToString("/")
    }
}

fun main() {
    val s = Solution()
    s.simplifyPath("/a/b/c").also { println(it) }
}