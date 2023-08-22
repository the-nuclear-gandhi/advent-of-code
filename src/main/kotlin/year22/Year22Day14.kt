package year22

import core.Day
import core.InputConverter.Companion.toLines
import shared.Point
import shared.PointRange

class Year22Day14 : Day<List<String>>(::toLines) {

    override fun part1(input: List<String>): Int = inputToRocks(input).let { rocks ->
        simulateFalling(rocks, rocks.maxOf { it.y })
    }

    override fun part2(input: List<String>): Int = inputToRocks(input).let { rocks ->
        simulateFalling(rocks, rocks.maxOf { it.y } + 2, true) + 1
    }

    private fun inputToRocks(input: List<String>): MutableSet<Point> =
        input.flatMap { it.split(" -> ").zipWithNext() }
            .map { PointRange(Point.fromString(it.first), Point.fromString(it.second)) }
            .flatMap { it.values }
            .toMutableSet()

    private fun simulateFalling(rocks: MutableSet<Point>, maxY: Int, withFloor: Boolean = false): Int {
        val startingPoint = Point(500, 0)
        var p = startingPoint

        var landedCount = 0
        while (true) {
            val nextPoint = listOf(
                Point(p.x, p.y + 1),
                Point(p.x - 1, p.y + 1),
                Point(p.x + 1, p.y + 1)
            )
                .filterNot { withFloor && it.y == maxY }
                .firstOrNull { it !in rocks }

            p = when {
                nextPoint == null && p == startingPoint -> return landedCount
                nextPoint == null -> {
                    rocks += p
                    landedCount++
                    startingPoint
                }

                !withFloor && nextPoint.y > maxY -> return landedCount
                else -> nextPoint
            }
        }
    }
}
