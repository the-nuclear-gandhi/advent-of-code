package shared

import kotlin.math.absoluteValue
import kotlin.math.sign

data class PointRange(val start: Point, val end: Point) {

    val values: List<Point> by lazy {
        var x = start.x
        var y = start.y

        val xIncline = end.x - start.x
        val yIncline = end.y - start.y
        mutableListOf<Point>().apply {
            while (x != end.x || y != end.y) {
                this += Point(x, y)
                x += 1 * xIncline.sign
                y += 1 * yIncline.sign
            }

            this += end
        }.toList()
    }

    val size: Int by lazy {
        when {
            isVertical() -> (end.x - start.x).absoluteValue + 1
            isHorizontal() -> (end.y - start.y).absoluteValue + 1
            else -> values.size
        }
    }

    /*
        since AoC normally uses the coordinate systems where 0,0 is in the top left corner, the x-axis is going
        downwards & the y-axis left to right the horizontal & vertical ranges are not the same as on the normal
        mathematical coordinate system
     */
    fun isVertical(): Boolean = start.y == end.y

    fun isHorizontal(): Boolean = start.x == end.x
}
