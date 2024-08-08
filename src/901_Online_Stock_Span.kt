package `901_Online_Stock_Span`

class StockSpanner() {

    val stack = mutableListOf<Int>()

    fun next(price: Int): Int {

        var diff = 1

        for (i in stack.size - 1 downTo 0) {
            if (stack[i] <= price) {
                diff++
            } else {
                break
            }
        }

        stack.add(price)
        return diff
    }
}

fun main() {
    val stockSpanner = StockSpanner()
    stockSpanner.next(100).also(::println)
    stockSpanner.next(80).also(::println)  // return 1
    stockSpanner.next(60).also(::println)  // return 1
    stockSpanner.next(70).also(::println)  // return 2
    stockSpanner.next(60).also(::println)  // return 1
    stockSpanner.next(75).also(::println)  // return 4, because the last 4 prices (including 
    stockSpanner.next(85).also(::println)  // return 4, because the last 4 prices (including
}