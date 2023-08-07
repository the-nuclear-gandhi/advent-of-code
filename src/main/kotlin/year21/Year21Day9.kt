package year21

import core.Day
import core.InputConverter.Companion.toLines
import shared.Point

class Year21Day9 : Day<List<String>>(::toLines) {

    override fun part1(input: List<String>): Int = parseHeightMap(input).let { heightMap ->
        findLowPoints(heightMap).sumOf { it.value + 1 }
    }

    override fun part2(input: List<String>): Long = parseHeightMap(input).let { heightMap ->
        findLowPoints(heightMap).map { findBasin(it.key, heightMap).size.toLong() }
            .sortedDescending()
            .take(3)
            .reduce { acc, i -> acc * i }
    }

    private fun parseHeightMap(input: List<String>): Map<Point, Int> =
        input.flatMapIndexed { index, s -> s.indices.map { Point(index, it) to s[it].toString().toInt() } }
            .associate { it.first to it.second }

    private fun findLowPoints(heightMap: Map<Point, Int>): Set<Map.Entry<Point, Int>> = heightMap.filterKeys { key ->
        key.neighbours()
            .filter { it in heightMap.keys }
            .all { heightMap.getValue(it) > heightMap.getValue(key) }
    }.entries

    private fun findBasin(lowPoint: Point, heightMap: Map<Point, Int>): Set<Point> {
        val pointsToVisit = mutableListOf(lowPoint)
        val visitedPoints = mutableSetOf<Point>()
        while (pointsToVisit.isNotEmpty()) {
            val visiting = pointsToVisit.removeFirst()
            visiting.neighbours()
                .filter { it !in visitedPoints && it in heightMap.keys }
                .filter { heightMap.getValue(it) < 9 }
                .let { pointsToVisit += it }

            visitedPoints += visiting
        }

        return visitedPoints
    }
}
