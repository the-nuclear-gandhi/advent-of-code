package year24

import core.Day
import core.InputConverter.Companion.toLineBlocks
import shared.LineBlock
import shared.Point
import shared.PointRange

class Year24Day15 : Day<List<LineBlock>>(::toLineBlocks) {

    override fun part1(input: List<LineBlock>): Int = input.let { (initialMap, instructions) ->
        val map = initialMap.map { it.toCharArray() }.toTypedArray()

        var robotPosition = findRobotPosition(map)

        instructions.flatMap { it.toList() }
            .map(Direction::of)
            .forEach { direction ->
                val nextPosition = nextPoint(robotPosition, direction)

                val targetPoints = when (map[nextPosition.x][nextPosition.y]) {
                    '.' -> PointRange(nextPosition, robotPosition)
                    'O' -> findEndPoint(map, robotPosition, direction)?.let {
                        PointRange(it, robotPosition)
                    }

                    else -> null
                }

                targetPoints?.let {
                    it.values.zipWithNext { previous, next ->
                        map[previous.x][previous.y] = map[next.x][next.y]
                        map[next.x][next.y] = '.'
                    }

                    robotPosition = nextPosition
                }
            }


        map.flatMapIndexed { x, array ->
            array.mapIndexed { y, c -> Point(x, y).takeIf { c == 'O' } }.filterNotNull()
        }.sumOf { it.x * 100 + it.y }
    }

    private fun findRobotPosition(map: Array<CharArray>): Point = map.flatMapIndexed { x, array ->
        array.mapIndexed { y, c -> Point(x, y).takeIf { c == '@' } }.filterNotNull()
    }.first()

    private fun nextPoint(point: Point, direction: Direction): Point {
        val xInc = when (direction) {
            Direction.UP -> -1
            Direction.DOWN -> 1
            else -> 0
        }
        val yInc = when (direction) {
            Direction.LEFT -> -1
            Direction.RIGHT -> 1
            else -> 0
        }

        return Point(point.x + xInc, point.y + yInc)
    }

    private fun findEndPoint(map: Array<CharArray>, start: Point, direction: Direction): Point? {
        var endPoint = start
        while (map[endPoint.x][endPoint.y] != '.' && map[endPoint.x][endPoint.y] != '#') {
            endPoint = nextPoint(endPoint, direction)
        }

        return endPoint.takeIf { map[it.x][it.y] == '.' }
    }

    override fun part2(input: List<LineBlock>): Int = input.let { (initialMap, instructions) ->
        var map = convertMap(initialMap)
        var robotPosition = findRobotPosition(map)

        instructions.flatMap { it.toList() }
            .map(Direction::of)
            .forEach { direction ->
                val nextPosition = nextPoint(robotPosition, direction)
                val targetPoints = when (map[nextPosition.x][nextPosition.y]) {
                    '.' -> PointRange(nextPosition, robotPosition)

                    '[', ']' -> when (direction) {
                        Direction.LEFT, Direction.RIGHT -> findEndPoint(map, robotPosition, direction)?.let {
                            PointRange(it, robotPosition)
                        }

                        Direction.UP, Direction.DOWN -> {
                            map = moveBoxes(map, nextPosition, direction)
                            PointRange(nextPosition, robotPosition).takeIf { map[nextPosition.x][nextPosition.y] == '.' }
                        }
                    }

                    else -> null
                }

                targetPoints?.let {
                    it.values.zipWithNext { previous, next ->
                        map[previous.x][previous.y] = map[next.x][next.y]
                        map[next.x][next.y] = '.'
                    }

                    robotPosition = nextPosition
                }
            }

        map.flatMapIndexed { x, array ->
            array.mapIndexed { y, c -> Point(x, y).takeIf { c == '[' } }.filterNotNull()
        }.sumOf { it.x * 100 + it.y }
    }

    private fun convertMap(initialMap: List<String>): Array<CharArray> = initialMap.map { s ->
        s.map {
            when (it) {
                'O' -> "[]"
                '@' -> "@."
                else -> "$it$it"
            }
        }
            .joinToString("")
            .toCharArray()
    }.toTypedArray()

    private fun moveBoxes(map: Array<CharArray>, boxPosition: Point, direction: Direction): Array<CharArray> {
        val boxPositionPair = if (map[boxPosition.x][boxPosition.y] == '[') {
            boxPosition to boxPosition.copy(y = boxPosition.y + 1)
        } else {
            boxPosition.copy(y = boxPosition.y - 1) to boxPosition
        }

        return if (isMovable(map, boxPositionPair, direction)) {
            moveBox(map, boxPositionPair, direction)
        } else {
            map
        }
    }

    private fun moveBox(
        map: Array<CharArray>,
        boxPosition: Pair<Point, Point>,
        direction: Direction
    ): Array<CharArray> {
        var updatedMap = map
        val nextPositions = boxPosition.toList().map { nextPoint(it, direction) }
        nextPositions.forEach {
            updatedMap = when (updatedMap[it.x][it.y]) {
                '[' -> moveBox(map, it to it.copy(y = it.y + 1), direction)
                ']' -> moveBox(map, it.copy(y = it.y - 1) to it, direction)
                else -> updatedMap
            }
        }

        if (nextPositions.all { updatedMap[it.x][it.y] == '.' }) {
            listOf(nextPositions[0] to boxPosition.first, nextPositions[1] to boxPosition.second).forEach {
                updatedMap[it.first.x][it.first.y] = updatedMap[it.second.x][it.second.y]
                updatedMap[it.second.x][it.second.y] = '.'
            }
        }

        return updatedMap
    }

    private fun isMovable(map: Array<CharArray>, boxPosition: Pair<Point, Point>, direction: Direction): Boolean =
        boxPosition.toList().map { nextPoint(it, direction) }
            .map {
                when (map[it.x][it.y]) {
                    '#' -> false
                    '[' -> isMovable(map, it to it.copy(y = it.y + 1), direction)
                    ']' -> isMovable(map, it.copy(y = it.y - 1) to it, direction)
                    else -> true
                }
            }
            .reduce { acc, b -> acc && b }

    private enum class Direction {
        UP, DOWN, LEFT, RIGHT;

        companion object {
            internal fun of(char: Char): Direction = when (char) {
                '^' -> UP
                '>' -> RIGHT
                'v' -> DOWN
                '<' -> LEFT
                else -> throw IllegalArgumentException("Unknown direction: $char")
            }
        }
    }
}
