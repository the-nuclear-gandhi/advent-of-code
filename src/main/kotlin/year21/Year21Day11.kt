package year21

import core.Day
import core.InputConverter.Companion.toLines
import shared.Point

class Year21Day11 : Day<List<String>>(::toLines) {

    override fun part1(input: List<String>): Int = parseLightMap(input).run {
        var lightMap = this
        var flashCount = 0
        repeat(100) { _ ->
            lightMap = simulateFlashing(lightMap).also { flashCount += lightMap.count { it.value == 0 } }
        }

        flashCount
    }

    override fun part2(input: List<String>): Int = parseLightMap(input).run {
        var lightMap = this
        var day = 0
        while (this.any { it.value != 0 }) {
            lightMap = simulateFlashing(lightMap).also { day++ }
        }

        day
    }

    private fun parseLightMap(input: List<String>): MutableMap<Point, Int> =
        input.flatMapIndexed { index, s -> s.indices.map { Point(index, it) to s[it].toString().toInt() } }
            .associate { it.first to it.second }
            .toMutableMap()

    private fun simulateFlashing(lightMap: MutableMap<Point, Int>): MutableMap<Point, Int> {
        lightMap.keys.forEach { lightMap.computeIfPresent(it) { _, v -> v + 1 } }

        val flashingPoints = lightMap.filter { it.value > 9 }.map { it.key }.toMutableList()
        val visitedPoints = mutableSetOf<Point>()

        while (flashingPoints.isNotEmpty()) {
            val flashingPoint = flashingPoints.removeFirst()
            if (flashingPoint !in visitedPoints) {
                flashingPoint.neighbours(true)
                    .filter { it in lightMap.keys }
                    .onEach { lightMap.computeIfPresent(it) { _, v -> v + 1 } }
                    .filter { lightMap.getValue(it) > 9 }
                    .forEach { flashingPoints += it }
            }
            visitedPoints += flashingPoint
        }

        visitedPoints.filter { it in lightMap.keys }.forEach { lightMap[it] = 0 }

        return lightMap
    }
}
