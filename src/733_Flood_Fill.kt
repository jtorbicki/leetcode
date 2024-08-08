package `733_Flood_Fill`
//
//class Solution {
//    private val visited: MutableMap<Int, MutableSet<Int>> = mutableMapOf()
//
//    fun floodFill(image: Array<IntArray>, sr: Int, sc: Int, color: Int): Array<IntArray> {
//        if (isVisited(sr, sc)) {
//            return image
//        }
//        markVisited(sr, sc)
//
//        val thisColor = image[sr][sc]
//        if (sr > 0 && image[sr - 1][sc] == thisColor) floodFill(image, sr - 1, sc, color)
//        if (sc < image[0].size - 1 && image[sr][sc + 1] == thisColor) floodFill(image, sr, sc + 1, color)
//        if (sr < image.size - 1 && image[sr + 1][sc] == thisColor) floodFill(image, sr + 1, sc, color)
//        if (sc > 0 && image[sr][sc - 1] == thisColor) floodFill(image, sr, sc - 1, color)
//        image[sr][sc] = color
//        return image
//    }
//
//    private fun isVisited(sr: Int, sc: Int): Boolean = visited[sr]?.contains(sc) ?: false
//
//    private fun markVisited(sr: Int, sc: Int) {
//        if (visited[sr] == null) {
//            visited[sr] = mutableSetOf(sc)
//        } else {
//            visited[sr]!!.add(sc)
//        }
//    }
//}


class Solution {

    fun floodFill(image: Array<IntArray>, sr: Int, sc: Int, color: Int): Array<IntArray> {
        if (image[sr][sc] == color) return image
        val thisColor = image[sr][sc]
        image[sr][sc] = color
        if (sr > 0 && image[sr - 1][sc] == thisColor) floodFill(image, sr - 1, sc, color)
        if (sc < image[0].size - 1 && image[sr][sc + 1] == thisColor) floodFill(image, sr, sc + 1, color)
        if (sr < image.size - 1 && image[sr + 1][sc] == thisColor) floodFill(image, sr + 1, sc, color)
        if (sc > 0 && image[sr][sc - 1] == thisColor) floodFill(image, sr, sc - 1, color)
        return image
    }
}


fun main(args: Array<String>) {
    val solution = Solution()
    val a = solution.floodFill(arrayOf(intArrayOf(1, 1, 1), intArrayOf(1, 1, 0), intArrayOf(1, 0, 1)), 1, 1, 2)
    val b = 1
}
