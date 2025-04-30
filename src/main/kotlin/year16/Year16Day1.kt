package year16

import core.Day
import core.InputConverter.Companion.trimming
import shared.Direction
import shared.Direction.*
import shared.Point
import kotlin.math.abs

class Year16Day1 : Day<String>(::trimming) {

    override fun part1(input: String): Int = getDistance(input, false)

    override fun part2(input: String): Int = getDistance(input, true)

    private fun getDistance(input: String, exitOnLoop: Boolean): Int =
        simulateMovement(input.split(", "), exitOnLoop).run { abs(x) + abs(y) }

    private fun simulateMovement(rules: List<String>, exitOnLoop: Boolean): Point {
        val directions = Direction.entries
        val visited = mutableSetOf<Point>()

        var point = Point(0, 0)
        var direction = UP

        for (rule in rules) {
            val turnDirection = Direction.of(rule[0])
            val distance = rule.substring(1).toInt()

            val directionIndex = directions.indexOf(direction)
            val nextDirectionIndex = directionIndex + when (turnDirection) {
                RIGHT -> 1
                LEFT -> -1
                else -> 0
            }

            direction = when {
                nextDirectionIndex == directions.size -> directions.first()
                nextDirectionIndex < 0 -> directions.last()
                else -> directions[nextDirectionIndex]
            }

            repeat(distance) {
                point = point.nextInDirection(direction)
                val addResult = visited.add(point)
                if (exitOnLoop && !addResult) {
                    return point
                }
            }
        }

        return point
    }
}
