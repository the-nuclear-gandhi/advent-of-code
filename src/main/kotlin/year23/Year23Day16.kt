package year23

import core.Day
import core.InputConverter.Companion.toLines
import shared.Point

class Year23Day16 : Day<List<String>>(::toLines) {
    override fun part1(input: List<String>): Int =
        countEnergizedPointsForBeam(input, DirectionPoint(0, 0, Direction.EAST))

    private fun countEnergizedPointsForBeam(input: List<String>, startingBeam: DirectionPoint): Int {
        val energizedPoints = mutableSetOf<DirectionPoint>()
        val lightBeams = mutableListOf(startingBeam)
        while (lightBeams.isNotEmpty()) {
            val beam = lightBeams.removeFirst()
            energizedPoints += beam

            when (input[beam.x][beam.y]) {
                '-' -> handleHorizontalSplitter(beam)
                '|' -> handleVerticalSplitter(beam)
                '/' -> handleMirror(beam)
                '\\' -> handleReversedMirror(beam)
                else -> listOf(beam.nextPoint())
            }
                .filter { it.x in input.indices && it.y in input[it.x].indices }
                .filter { it !in energizedPoints }
                .forEach { lightBeams += it }

        }

        return energizedPoints.map { Point(it.x, it.y) }.toSet().size
    }

    private fun handleHorizontalSplitter(directionPoint: DirectionPoint): List<DirectionPoint> =
        if (directionPoint.direction in listOf(Direction.EAST, Direction.WEST)) {
            listOf(directionPoint.nextPoint())
        } else {
            listOf(
                DirectionPoint(directionPoint.x, directionPoint.y - 1, Direction.WEST),
                DirectionPoint(directionPoint.x, directionPoint.y + 1, Direction.EAST)
            )
        }

    private fun handleVerticalSplitter(directionPoint: DirectionPoint): List<DirectionPoint> =
        if (directionPoint.direction in listOf(Direction.NORTH, Direction.SOUTH)) {
            listOf(directionPoint.nextPoint())
        } else {
            listOf(
                DirectionPoint(directionPoint.x - 1, directionPoint.y, Direction.NORTH),
                DirectionPoint(directionPoint.x + 1, directionPoint.y, Direction.SOUTH)
            )
        }

    private fun handleMirror(directionPoint: DirectionPoint): List<DirectionPoint> = listOf(
        when (directionPoint.direction) {
            Direction.NORTH -> DirectionPoint(directionPoint.x, directionPoint.y + 1, Direction.EAST)
            Direction.EAST -> DirectionPoint(directionPoint.x - 1, directionPoint.y, Direction.NORTH)
            Direction.SOUTH -> DirectionPoint(directionPoint.x, directionPoint.y - 1, Direction.WEST)
            Direction.WEST -> DirectionPoint(directionPoint.x + 1, directionPoint.y, Direction.SOUTH)
        }
    )

    private fun handleReversedMirror(directionPoint: DirectionPoint): List<DirectionPoint> = listOf(
        when (directionPoint.direction) {
            Direction.NORTH -> DirectionPoint(directionPoint.x, directionPoint.y - 1, Direction.WEST)
            Direction.EAST -> DirectionPoint(directionPoint.x + 1, directionPoint.y, Direction.SOUTH)
            Direction.SOUTH -> DirectionPoint(directionPoint.x, directionPoint.y + 1, Direction.EAST)
            Direction.WEST -> DirectionPoint(directionPoint.x - 1, directionPoint.y, Direction.NORTH)
        }
    )

    override fun part2(input: List<String>): Int =
        input[0].indices.flatMap {
            listOf(
                DirectionPoint(0, it, Direction.SOUTH),
                DirectionPoint(input.size - 1, it, Direction.NORTH)
            )
        }
            .toMutableSet()
            .apply {
                input.indices.flatMap {
                    listOf(
                        DirectionPoint(it, 0, Direction.EAST),
                        DirectionPoint(it, input[it].length - 1, Direction.WEST)
                    )
                }
                    .toSet()
                    .let { this.addAll(it) }
            }
            .maxOf { countEnergizedPointsForBeam(input, it) }

    private enum class Direction {
        NORTH, EAST, SOUTH, WEST
    }

    private data class DirectionPoint(val x: Int, val y: Int, val direction: Direction) {

        fun nextPoint(): DirectionPoint = when (direction) {
            Direction.NORTH -> DirectionPoint(x - 1, y, direction)
            Direction.EAST -> DirectionPoint(x, y + 1, direction)
            Direction.SOUTH -> DirectionPoint(x + 1, y, direction)
            Direction.WEST -> DirectionPoint(x, y - 1, direction)
        }
    }
}
