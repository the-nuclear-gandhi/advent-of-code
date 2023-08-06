package year22

import core.Day
import core.InputConverter.Companion.toLines
import shared.Point

class Year22Day12 : Day<List<String>>(::toLines) {

    override fun part1(input: List<String>): Int = calculateMinDistanceFromEnd(input).let { distances ->
        val start = findPoint(input, "S")
        distances[start]
    }

    override fun part2(input: List<String>): Int = calculateMinDistanceFromEnd(input).let { distances ->
        input.flatMapIndexed { dx, s ->
            s.mapIndexedNotNull { dy, c ->
                Point(dx, dy).takeIf { c == 'a' || c == 'S' }
            }
        }
            .minOf { distances[it] }
    }

    private fun calculateMinDistanceFromEnd(input: List<String>): Array<IntArray> {
        val start = findPoint(input, "S")
        val end = findPoint(input, "E")
        val heights = input.map { it.replace("S", "a").replace("E", "z") }.toList()
        val distances = Array(heights.size) { IntArray(heights[0].length) { Integer.MAX_VALUE } }
        distances[end] = 0

        val queue = mutableListOf(end)
        while (queue.isNotEmpty()) {
            val point = queue.removeFirst()
            val accessibleNeighbors = point.neighbours()
                .filter { it.x in heights.indices && it.y in heights[0].indices }
                .filter { heights[point] - heights[it] < 2 }

            if (point != start) {
                val distance = distances[point] + 1
                accessibleNeighbors.forEach {
                    if (distance < distances[it]) {
                        distances[it] = distance
                        queue += it
                    }
                }
            }
        }

        return distances
    }

    private fun findPoint(list: List<String>, targetChar: String): Point = with(list) {
        val x = this.indexOfFirst { it.contains(targetChar) }
        val y = this[x].indexOf(targetChar)
        Point(x, y)
    }

    private operator fun Array<IntArray>.get(point: Point): Int = this[point.x][point.y]

    private operator fun Array<IntArray>.set(point: Point, value: Int) {
        this[point.x][point.y] = value
    }

    private operator fun List<String>.get(point: Point): Char = this[point.x][point.y]
}
