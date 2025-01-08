package year24

import core.Day
import core.InputConverter.Companion.toLines
import shared.Point

class Year24Day8 : Day<List<String>>(::toLines) {

    override fun part1(input: List<String>): Int = inputToAntennaPairs(input)
        .map {
            val dx = it.second.x - it.first.x
            val dy = it.second.y - it.first.y

            Point(it.second.x + dx, it.second.y + dy)
        }
        .toSet()
        .count { it.x in input.indices && it.y in input[it.x].indices }

    override fun part2(input: List<String>): Int {
        val resultMap = Array(input.size) { IntArray(input[0].length) }

        inputToAntennaPairs(input).forEach {
            val dx = it.second.x - it.first.x
            val dy = it.second.y - it.first.y

            var point = it.second
            while (point.x in resultMap.indices && point.y in resultMap[point.x].indices) {
                resultMap[point.x][point.y] = 1
                point = Point(point.x + dx, point.y + dy)
            }
        }

        return resultMap.sumOf { it.sum() }
    }

    private fun inputToAntennaPairs(input: List<String>): List<Pair<Point, Point>> =
        input.flatMapIndexed { x, s -> s.mapIndexedNotNull { y, c -> Point(x, y).takeIf { c != '.' } } }
            .groupBy { input[it.x][it.y] }
            .values.flatMap { points ->
                points.flatMap {
                    points.filter { point -> point != it }.map { point -> it to point }
                }
            }
}
