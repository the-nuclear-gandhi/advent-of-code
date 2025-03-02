package year20

import core.Day
import core.InputConverter.Companion.toLines
import shared.Direction
import shared.Direction.*
import shared.Point
import kotlin.math.abs

class Year20Day12 : Day<List<String>>(::toLines) {

    override fun part1(input: List<String>): Int {
        var position = Point(0, 0)
        var direction = RIGHT
        val directions = Direction.entries

        inputToInstructions(input).forEach { (command, value) ->
            when (command) {
                'N', 'S', 'E', 'W' -> position = move(position, Direction.of(command), value)
                'F' -> position = move(position, direction, value)
                'R' -> {
                    val index = (directions.indexOf(direction) + value / 90) % directions.size
                    direction = directions[index]
                }

                'L' -> {
                    val index = (directions.indexOf(direction) - value / 90 + directions.size) % directions.size
                    direction = directions[index]
                }
            }
        }

        return abs(position.x) + abs(position.y)
    }

    private fun inputToInstructions(input: List<String>): List<Pair<Char, Int>> =
        input.map { it[0] to it.substring(1).toInt() }

    private fun move(position: Point, direction: Direction, distance: Int): Point = when (direction) {
        UP -> position.copy(y = position.y + distance)
        DOWN -> position.copy(y = position.y - distance)
        RIGHT -> position.copy(x = position.x + distance)
        LEFT -> position.copy(x = position.x - distance)
    }

    override fun part2(input: List<String>): Int {
        var position = Point(0, 0)
        var waypointPosition = Point(10, 1)

        inputToInstructions(input).forEach { (command, value) ->
            when (command) {
                'N', 'S', 'E', 'W' -> waypointPosition = move(waypointPosition, Direction.of(command), value)
                'F' -> position =
                    Point(position.x + waypointPosition.x * value, position.y + waypointPosition.y * value)

                'R' -> waypointPosition = when(value) {
                    90 -> Point(waypointPosition.y, -waypointPosition.x)
                    180 -> Point(-waypointPosition.x, -waypointPosition.y)
                    270 -> Point(-waypointPosition.y, waypointPosition.x)
                    else -> waypointPosition
                }

                'L' -> waypointPosition = when(value) {
                    90 -> Point(-waypointPosition.y, waypointPosition.x)
                    180 -> Point(-waypointPosition.x, -waypointPosition.y)
                    270 -> Point(waypointPosition.y, -waypointPosition.x)
                    else -> waypointPosition
                }
            }
        }

        return abs(position.x) + abs(position.y)
    }
}
