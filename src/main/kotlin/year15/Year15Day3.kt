package year15

import core.Day
import core.InputConverter.Companion.noOp
import shared.Direction
import shared.Point

class Year15Day3 : Day<String>(::noOp) {

    override fun part1(input: String): Int {
        var santaLocation = Point(0, 0)
        val visitedPoints = mutableSetOf(santaLocation)

        input.map(Direction::of).forEach {
            santaLocation = santaLocation.nextInDirection(it)
            visitedPoints += santaLocation
        }

        return visitedPoints.size
    }

    override fun part2(input: String): Int {
        var santaLocation = Point(0, 0)
        val visitedPoints = mutableSetOf(santaLocation)
        var robotSantaLocation = santaLocation

        input.map(Direction::of).forEachIndexed { index, direction ->
            if (index % 2 == 0) {
                santaLocation = santaLocation.nextInDirection(direction)
                visitedPoints += santaLocation
            } else {
                robotSantaLocation = robotSantaLocation.nextInDirection(direction)
                visitedPoints += robotSantaLocation
            }
        }

        return visitedPoints.size
    }
}
