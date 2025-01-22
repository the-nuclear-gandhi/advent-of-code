package year24

import core.Day
import core.InputConverter.Companion.toLines
import shared.Point
import shared.toIntList

class Year24Day10 : Day<List<String>>(::toLines) {

    override fun part1(input: List<String>): Int = calculateTrails(input).sumOf { it.distinct().size }

    override fun part2(input: List<String>): Int = calculateTrails(input).sumOf { it.size }

    private fun calculateTrails(input: List<String>): List<List<Point>> = with(input.map { it.toIntList("") }) {
        this.flatMapIndexed { x, ints -> ints.mapIndexedNotNull { y, i -> Point(x, y).takeIf { i == 0 } } }
            .map { calculateTrailEnds(it, this) }
    }

    private fun calculateTrailEnds(point: Point, map: List<List<Int>>): List<Point> = buildList {
        val pointsToVisit = mutableListOf(point)
        while (pointsToVisit.isNotEmpty()) {
            val current = pointsToVisit.removeFirst()
            val currentValue = map[current.x][current.y]
            if (currentValue == 9) {
                this += current
            } else {
                current.neighbours(false)
                    .filter { it.x in map.indices && it.y in map[it.x].indices }
                    .filter { map[it.x][it.y] - currentValue == 1 }
                    .forEach { pointsToVisit += it }
            }
        }
    }
}
