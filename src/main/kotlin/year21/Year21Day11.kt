package year21

import shared.Day
import shared.InputConverter.Companion.toLines
import shared.Point

class Year21Day11 : Day<List<String>>(::toLines) {

    override fun part1(input: List<String>): Int = parseValuePoints(input).let {
        var valuePoints = it
        var flashCount = 0
        repeat(100) {
            valuePoints = simulateFlashing(valuePoints)
            flashCount += valuePoints.count { valuePoint -> valuePoint.value == 0 }
        }

        flashCount
    }

    override fun part2(input: List<String>): Int = parseValuePoints(input).let {
        var valuePoints = it
        var day = 0

        while (valuePoints.any { valuePoint -> valuePoint.value != 0 }) {
            valuePoints = simulateFlashing(valuePoints)
            day++
        }

        day
    }

    private fun parseValuePoints(input: List<String>): List<ValuePoint> = input.flatMapIndexed { index, s ->
        s.indices.map { ValuePoint(Point(index, it), s[it].toString().toInt()) }
    }

    private fun simulateFlashing(valuePoints: List<ValuePoint>): List<ValuePoint> {
        valuePoints.forEach { it.value++ }

        val flashingPoints = valuePoints.filter { it.value > 9 }.toMutableList()
        val visitedPoints = mutableSetOf<Point>()

        while (flashingPoints.isNotEmpty()) {
            val flashingPoint = flashingPoints.removeFirst()
            if (flashingPoint.point !in visitedPoints) {
                flashingPoint.neighbours().mapNotNull { valuePoints.findByPoint(it) }
                    .onEach { it.value++ }
                    .filter { it.value > 9 }
                    .forEach { flashingPoints.add(it) }
            }
            visitedPoints.add(flashingPoint.point)
        }

        visitedPoints.mapNotNull { valuePoints.findByPoint(it) }
            .forEach { it.value = 0 }

        return valuePoints
    }

    private data class ValuePoint(val point: Point, var value: Int) {
        fun neighbours(): List<Point> = point.neighbours(true)
    }

    private fun List<ValuePoint>.findByPoint(point: Point): ValuePoint? = this.firstOrNull { it.point == point }
}
