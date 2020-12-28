package year21

import shared.Day
import shared.Point

class Year21Day9 : Day<List<String>>() {
    override fun getInput(): List<String> = inputResource().asLines()

    override fun part1(input: List<String>): Int = parseValuePoints(input).let { valuePoints ->
        findLowPoints(valuePoints).sumOf { it.value + 1 }
    }

    override fun part2(input: List<String>): Long = parseValuePoints(input).let { valuePoints ->
        findLowPoints(valuePoints).map { findBasin(it, valuePoints).size.toLong() }
            .sortedDescending()
            .take(3)
            .reduce { acc, i -> acc * i }
    }

    private fun parseValuePoints(input: List<String>): List<ValuePoint> = input.flatMapIndexed { index, s ->
        s.indices.map {
            ValuePoint(Point(index, it), s[it].toString().toInt())
        }
    }

    private fun findLowPoints(valuePoints: List<ValuePoint>): List<ValuePoint> = valuePoints.filter {
        it.neighbours()
            .mapNotNull { point -> valuePoints.findByPoint(point) }
            .all { valuePoint -> valuePoint > it }
    }

    private fun findBasin(lowPoint: ValuePoint, valuePoints: List<ValuePoint>): Set<Point> {
        val pointsToVisit = mutableListOf(lowPoint)
        val visitedPoints = mutableSetOf<Point>()
        while (pointsToVisit.isNotEmpty()) {
            val visiting = pointsToVisit.removeFirst()
            visiting.neighbours()
                .filter { it !in visitedPoints }
                .mapNotNull { valuePoints.findByPoint(it) }
                .filter { it.value < 9 }
                .let { pointsToVisit.addAll(it) }

            visitedPoints.add(visiting.point)
        }

        return visitedPoints
    }

    private data class ValuePoint(val point: Point, val value: Int) {
        operator fun compareTo(other: ValuePoint): Int = value - other.value

        fun neighbours(): List<Point> = (point.x - 1..point.x + 1).flatMap { dx ->
            (point.y - 1..point.y + 1).mapNotNull { dy ->
                Point(dx, dy).takeIf { dx == point.x || dy == point.y }.takeUnless { it == point }
            }
        }
    }

    private fun List<ValuePoint>.findByPoint(point: Point): ValuePoint? = this.firstOrNull { it.point == point }
}