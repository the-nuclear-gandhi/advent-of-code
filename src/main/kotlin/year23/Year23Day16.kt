package year23

import core.Day
import core.InputConverter.Companion.toLines
import shared.Direction
import shared.Direction.*
import shared.Point

class Year23Day16 : Day<List<String>>(::toLines) {

    override fun part1(input: List<String>): Int =
        countEnergizedPointsForBeam(input, DirectedBeam(Point(0, 0), RIGHT))

    private fun countEnergizedPointsForBeam(input: List<String>, startingBeam: DirectedBeam): Int {
        val energizedPoints = mutableSetOf<DirectedBeam>()
        val lightBeams = mutableListOf(startingBeam)
        while (lightBeams.isNotEmpty()) {
            val beam = lightBeams.removeFirst()
            energizedPoints += beam

            val nextPoints = when (input[beam.position.x][beam.position.y]) {
                '-' -> handleHorizontalSplitter(beam)
                '|' -> handleVerticalSplitter(beam)
                '/' -> handleMirror(beam)
                '\\' -> handleReversedMirror(beam)
                else -> listOf(beam.nextPoint())
            }

            nextPoints
                .filter { it.position.x in input.indices && it.position.y in input[it.position.x].indices }
                .filterNot { it in energizedPoints }
                .run { lightBeams.addAll(this) }

        }

        return energizedPoints.distinctBy { it.position }.size
    }

    private fun handleHorizontalSplitter(directedBeam: DirectedBeam): List<DirectedBeam> =
        when (directedBeam.direction) {
            LEFT, RIGHT -> listOf(directedBeam.nextPoint())
            else -> listOf(LEFT, RIGHT).map { DirectedBeam(directedBeam.position.nextInDirection(it), it) }
        }

    private fun handleVerticalSplitter(directedBeam: DirectedBeam): List<DirectedBeam> =
        when (directedBeam.direction) {
            UP, DOWN -> listOf(directedBeam.nextPoint())
            else -> listOf(UP, DOWN).map { DirectedBeam(directedBeam.position.nextInDirection(it), it) }
        }

    private fun handleMirror(directedBeam: DirectedBeam): List<DirectedBeam> = buildList {
        val nextDirection = when (directedBeam.direction) {
            UP -> RIGHT
            RIGHT -> UP
            DOWN -> LEFT
            LEFT -> DOWN
        }

        this += DirectedBeam(directedBeam.position.nextInDirection(nextDirection), nextDirection)
    }

    private fun handleReversedMirror(directedBeam: DirectedBeam): List<DirectedBeam> = buildList {
        val nextDirection = when (directedBeam.direction) {
            UP -> LEFT
            RIGHT -> DOWN
            DOWN -> RIGHT
            LEFT -> UP
        }

        this += DirectedBeam(directedBeam.position.nextInDirection(nextDirection), nextDirection)
    }

    override fun part2(input: List<String>): Int =
        input[0].indices.flatMap {
            listOf(
                DirectedBeam(Point(0, it), DOWN),
                DirectedBeam(Point(input.size - 1, it), UP)
            )
        }
            .toMutableSet()
            .apply {
                input.indices.flatMap {
                    listOf(
                        DirectedBeam(Point(it, 0), RIGHT),
                        DirectedBeam(Point(it, input[it].length - 1), LEFT)
                    )
                }
                    .toSet()
                    .let { this.addAll(it) }
            }
            .maxOf { countEnergizedPointsForBeam(input, it) }

    private data class DirectedBeam(val position: Point, val direction: Direction) {
        fun nextPoint(): DirectedBeam = this.copy(position = this.position.nextInDirection(direction))
    }
}
