package year15

import shared.Day
import shared.Point

class Year15Day3 : Day<String>() {

    override fun getInput(): String = inputResource().asString()

    override fun part1(input: String): Int {
        var santaLocation = Point(0, 0)
        val visitedPoints = mutableSetOf(santaLocation)

        input.forEach {
            santaLocation = nextPoint(santaLocation, it)
            visitedPoints += santaLocation
        }

        return visitedPoints.size
    }

    override fun part2(input: String): Int {
        var santaLocation = Point(0, 0)
        val visitedPoints = mutableSetOf(santaLocation)
        var robotSantaLocation = santaLocation

        input.forEachIndexed { index, c ->
            if (index % 2 == 0) {
                santaLocation = nextPoint(santaLocation, c)
                visitedPoints += santaLocation
            } else {
                robotSantaLocation = nextPoint(robotSantaLocation, c)
                visitedPoints += robotSantaLocation
            }
        }

        return visitedPoints.size
    }

    private fun nextPoint(point: Point, direction: Char): Point = when (direction) {
        '>' -> Point(point.x + 1, point.y)
        'v' -> Point(point.x, point.y - 1)
        '<' -> Point(point.x - 1, point.y)
        '^' -> Point(point.x, point.y + 1)
        else -> point
    }
}
