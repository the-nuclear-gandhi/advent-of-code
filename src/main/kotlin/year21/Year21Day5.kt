package year21

import core.Day
import core.InputConverter.Companion.toLines
import shared.Point
import shared.PointRange
import java.util.function.Predicate

class Year21Day5 : Day<List<String>>(::toLines) {

    override fun part1(input: List<String>): Int = calculateResult(input) {
        it.isHorizontal() || it.isVertical()
    }

    override fun part2(input: List<String>): Int = calculateResult(input)

    private fun calculateResult(input: List<String>, pipelineFilter: Predicate<PointRange>? = null): Int {
        val pipelines = parseInput(input)
        val maxCoordinate = pipelines.flatMap { listOf(it.start.x, it.start.y, it.end.x, it.end.y) }
            .maxOrNull() ?: 9999

        val oceanFloor = Array(maxCoordinate + 1) { IntArray(maxCoordinate + 1) }

        pipelines.filter { pipelineFilter?.test(it) ?: true }
            .flatMap { it.values }
            .forEach { (x, y) -> oceanFloor[x][y]++ }

        return oceanFloor.flatMap { it.toList() }.count { it > 1 }
    }

    private fun parseInput(input: List<String>): List<PointRange> =
        input.flatMap { it.split(" -> ").map { token -> Point.fromString(token) } }
            .chunked(2)
            .map { PointRange(it.first(), it.last()) }
}
