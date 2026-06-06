package year16

import core.Day
import shared.Point

class Year16Day13(val target: Point = Point(31, 39)) : Day<Int>(::prepareInput) {

    private companion object {
        private fun prepareInput(input: String): Int = input.replace("\n", "").toInt()
    }

    override fun part1(input: Int): Int = calculateDistances(input, target).let { it[target.x][target.y] }

    override fun part2(input: Int): Int =
        calculateDistances(input, target).let { it.sumOf { row -> row.count { n -> n < 51 } } }

    private fun calculateDistances(input: Int, target: Point): Array<IntArray> {
        val map = Array(target.x * 2) { x ->
            BooleanArray(target.y * 2) { y ->
                Integer.toBinaryString(x*x + 3*x + 2*x*y + y + y*y + input).count { it == '1' } % 2 == 0
            }
        }

        val distances = Array(target.x * 2) { IntArray(target.y * 2) { Integer.MAX_VALUE } }
        distances[1][1] = 0

        val points = mutableListOf(Point(1, 1))
        while (points.isNotEmpty()) {
            val current = points.removeFirst()
            val distance = distances[current.x][current.y] + 1

            current.neighbours().filter { it.x in map.indices && it.y in map[it.x].indices }
                .filter { map[it.x][it.y] && distances[it.x][it.y] > distance }
                .forEach {
                    distances[it.x][it.y] = distance
                    points += it
                }
        }

        return distances
    }
}
