package `295_Find_Median_from_Data_Stream`

import java.util.*

class MedianFinder {

    val largeNumbersHeap = PriorityQueue<Int>()
    val smallNumbersHeap = PriorityQueue(reverseOrder<Int>())

    fun addNum(num: Int) {
        smallNumbersHeap.add(num)
        if (smallNumbersHeap.isNotEmpty() && largeNumbersHeap.isNotEmpty() && smallNumbersHeap.peek() > largeNumbersHeap.peek()) {
            largeNumbersHeap.add(smallNumbersHeap.poll())
        }

        if (largeNumbersHeap.size - smallNumbersHeap.size > 1) {
            smallNumbersHeap.add(largeNumbersHeap.poll())
        } else if (smallNumbersHeap.size - largeNumbersHeap.size > 1) {
            largeNumbersHeap.add(smallNumbersHeap.poll())
        }
    }

    fun findMedian(): Double = when {
        smallNumbersHeap.size == largeNumbersHeap.size -> (smallNumbersHeap.peek() + largeNumbersHeap.peek()) / 2.0
        smallNumbersHeap.size > largeNumbersHeap.size -> smallNumbersHeap.peek().toDouble()
        else -> largeNumbersHeap.peek().toDouble()
    }
}

fun main() {
    val s = MedianFinder()
    s.addNum(1)
    s.addNum(2)
    s.addNum(3)
    s.addNum(4)
    s.addNum(5)
    s.addNum(6)
    s.addNum(7)
    s.addNum(8)
    s.addNum(9)
    s.addNum(10)
    s.findMedian().also { println(it) }
}