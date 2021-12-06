package year21

import shared.Day
import shared.Point
import java.util.function.Predicate
import kotlin.math.sign

class Year21Day5 : Day<List<String>>() {
    override fun getInput(): List<String> = inputResource().asLines()

    override fun part1(input: List<String>): Int = calculateResult(input) {
        it.isHorizontal() || it.isVertical()
    }

    override fun part2(input: List<String>): Int = calculateResult(input)

    private fun calculateResult(input: List<String>, pipelineFilter: Predicate<Pipeline>? = null): Int {
        val pipelines = parseInput(input)
        val maxCoordinate = pipelines.flatMap { listOf(it.start.x, it.start.y, it.end.x, it.end.y) }
            .maxOrNull() ?: 9999

        val oceanFloor = Array(maxCoordinate + 1) { IntArray(maxCoordinate + 1) { 0 } }

        pipelines.filter { pipelineFilter?.test(it) ?: true }
            .flatMap { it.points() }
            .forEach { (x, y) -> oceanFloor[x][y]++ }

        return oceanFloor.flatMap { it.toList() }.count { it > 1 }
    }

    private fun parseInput(input: List<String>): List<Pipeline> =
        input.flatMap { it.split(" -> ").map { token -> token.split(",") }.flatten() }
            .map { it.toInt() }
            .chunked(4)
            .map { (x1, y1, x2, y2) -> Pipeline(Point(x1, y1), Point(x2, y2)) }

    private data class Pipeline(val start: Point, val end: Point) {
        fun points(): List<Point> {
            var x = start.x
            var y = start.y

            val xIncline = end.x - start.x
            val yIncline = end.y - start.y
            val points = mutableListOf<Point>()
            while (x != end.x || y != end.y) {
                points.add(Point(x, y))
                x += 1 * xIncline.sign
                y += 1 * yIncline.sign
            }
            points.add(end)
            return points
        }

        fun isHorizontal() = start.x == end.x
        fun isVertical() = start.y == end.y
    }
}
