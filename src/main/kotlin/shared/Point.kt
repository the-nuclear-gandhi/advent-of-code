package shared

import shared.Direction.*

data class Point(val x: Int, val y: Int) {

    companion object {
        fun fromString(s: String, separator: String = ","): Point = s.toIntList(separator)
            .let {
                require(it.size == 2) {
                    "Invalid arguments provided to construct a 2D Point, expected 2 values, got $it from String $s"
                }

                Point(it.first(), it.last())
            }
    }

    fun neighbours(diagonal: Boolean = false): List<Point> = (x - 1..x + 1).flatMap { dx ->
        (y - 1..y + 1).mapNotNull { dy ->
            Point(dx, dy).takeUnless { it == this }.let { p ->
                if (diagonal) {
                    p
                } else {
                    p?.takeIf { p.x == this.x || p.y == this.y }
                }
            }
        }
    }

    fun nextInDirection(direction: Direction): Point {
        val xInc = when (direction) {
            UP -> -1
            DOWN -> 1
            else -> 0
        }

        val yInc = when (direction) {
            LEFT -> -1
            RIGHT -> 1
            else -> 0
        }

        return Point(this.x + xInc, this.y + yInc)
    }
}
