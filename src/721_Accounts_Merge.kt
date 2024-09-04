package `721_Accounts_Merge`


class Solution {
    fun accountsMerge(accounts: List<List<String>>): List<List<String>> {

        val names = mutableMapOf<Int, String>()
        val ids = mutableMapOf<Int, Int>()
        val map = mutableMapOf<String, Int>()

        for ((accountIndex, account) in accounts.withIndex()) {
            val name = account[0]
            names[accountIndex] = name
            for (emailIndex in 1..account.lastIndex) {
                val email = account[emailIndex]
                map[email]?.let {
                    ids[accountIndex] = it
                }
                map[email] = accountIndex
            }
        }

        val result = mutableMapOf<Int, MutableList<String>>()

        for ((email, id) in map) {
            var parentId = id
            while (ids.containsKey(parentId)) {
                parentId = ids[parentId]!!
            }
            if (result.contains(parentId)) {
                val account = result[parentId]!!
                account.add(email)
            } else {
                val account = mutableListOf(names[parentId]!!, email)
                result[parentId] = account
            }
            result.getOrPut(parentId) {
                mutableListOf()
            }
        }

        return result.values.toList()
    }
}

fun main() {
    val s = Solution()
    s.accountsMerge(
        listOf(
            listOf("John","johnsmith@mail.com","john_newyork@mail.com"),
            listOf("John","johnsmith@mail.com","john00@mail.com"),
            listOf("Mary","mary@mail.com"),
            listOf("John","johnnybravo@mail.com"),
        )
    )
}