package year20

import core.Day
import core.InputConverter.Companion.toLines
import shared.Point

class Year20Day11 : Day<List<String>>(::toLines) {

    override fun part1(input: List<String>): Int = solve(input) { point, c, map ->
        when (c) {
            'L' -> '#'.takeIf { point.countOccupiedNeighbours(map) == 0 } ?: c
            '#' -> 'L'.takeIf { point.countOccupiedNeighbours(map) > 3 } ?: c
            else -> c
        }
    }

    override fun part2(input: List<String>): Int = solve(input) { point, c, map ->
        when (c) {
            'L' -> '#'.takeIf { point.countVisibleOccupiedSeats(map) == 0 } ?: c
            '#' -> 'L'.takeIf { point.countVisibleOccupiedSeats(map) > 4 } ?: c
            else -> c
        }
    }

    private fun solve(input: List<String>, seatMappingFunction: (Point, Char, List<String>) -> Char): Int {
        var previous = input
        var next = listOf<String>()

        while (next != previous) {
            next = previous.mapIndexed { x, s ->
                s.mapIndexed { y, c -> seatMappingFunction(Point(x, y), c, previous) }.joinToString("")
            }

            if (next != previous) {
                previous = next
                next = listOf()
            }
        }

        return next.sumOf { s -> s.count { it == '#' } }
    }

    private fun Point.countOccupiedNeighbours(map: List<String>): Int = this.neighbours(true)
        .filter { it.x in map.indices && it.y in map[x].indices }
        .count { map[it.x][it.y] == '#' }

    private fun Point.countVisibleOccupiedSeats(map: List<String>): Int = listOf(
        Pair(-1, -1), Pair(-1, 0), Pair(-1, 1),
        Pair(0, -1), Pair(0, 1),
        Pair(1, -1), Pair(1, 0), Pair(1, 1)
    )
        .map { this.pointsInDirection(map, it) }
        .mapNotNull { it.firstOrNull { c -> c != '.' } }
        .count { it == '#' }

    private fun Point.pointsInDirection(map: List<String>, direction: Pair<Int, Int>): List<Char> {
        val points = mutableListOf<Char>()
        var nextPoint = Point(this.x + direction.first, this.y + direction.second)
        while (nextPoint.x in map.indices && nextPoint.y in map[x].indices) {
            points += map[nextPoint.x][nextPoint.y]
            nextPoint = Point(nextPoint.x + direction.first, nextPoint.y + direction.second)
        }

        return points.toList()
    }
}
