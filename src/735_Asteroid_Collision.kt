package `735_Asteroid_Collision`

class Solution {
    fun asteroidCollision(asteroids: IntArray): IntArray {
        val stack = mutableListOf<Int>()
        var onlyLeft = true

        for (asteroid in asteroids) {
            when {
                asteroid > 0 -> {
                    stack.add(asteroid)
                    onlyLeft = false
                }
                asteroid < 0 && onlyLeft -> stack.add(asteroid)
                else ->  {
                    while (stack.isNotEmpty() && stack.last() > 0) {
                        when {
                            stack.last() == -asteroid -> {
                                stack.removeLast()
                                if (stack.isEmpty() || stack.last() < 0) {
                                    onlyLeft = true
                                }
                                break
                            }
                            stack.last() < -asteroid -> {
                                stack.removeLast()
                                if (stack.isEmpty() || stack.last() < 0) {
                                    onlyLeft = true
                                    stack.add(asteroid)
                                }
                            }
                            stack.last() > -asteroid -> break
                        }
                    }
                }
            }
        }

        return stack.toIntArray()
    }
}

fun main(args: Array<String>) {
    val solution = Solution()
    solution.asteroidCollision(intArrayOf(-2,1,-1,-2)).also { println(it.contentToString()) }
}