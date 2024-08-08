package `380_Insert_Delete_GetRandom_O(1)`

import java.util.TreeSet

class RandomizedSet() {

    val set = TreeSet<Int>()

    fun insert(`val`: Int): Boolean {
        return set.add(`val`)
    }

    fun remove(`val`: Int): Boolean {
        return set.remove(`val`)
    }

    fun getRandom(): Int {
        return set.random()
    }

}
