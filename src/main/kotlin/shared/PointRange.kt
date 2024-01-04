package shared

import kotlin.math.sign

data class PointRange(val start: Point, val end: Point) {

    val values by lazy {
        var x = start.x
        var y = start.y

        val xIncline = end.x - start.x
        val yIncline = end.y - start.y
        val points = mutableListOf<Point>()
        while (x != end.x || y != end.y) {
            points += Point(x, y)
            x += 1 * xIncline.sign
            y += 1 * yIncline.sign
        }
        points += end
        points.toList()
    }

    fun isVertical(): Boolean = start.x == end.x

    fun isHorizontal(): Boolean = start.y == end.y
}
