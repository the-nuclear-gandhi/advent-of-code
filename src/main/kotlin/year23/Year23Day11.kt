package year23

import core.Day
import core.InputConverter.Companion.toLines
import shared.Point
import kotlin.math.abs

class Year23Day11 : Day<List<String>>(::toLines) {

    override fun part1(input: List<String>): Long = solve(input, 2)

    override fun part2(input: List<String>): Long = solve(input, 1_000_000)

    internal fun solve(input: List<String>, expansionFactor: Int = 1): Long {
        val galaxies = input.flatMapIndexed { index, s ->
            s.indices.mapNotNull { Point(index, it).takeIf { _ -> s[it] == '#' } }
        }
            .toMutableList()

        val emptyRowIndices = input.mapIndexedNotNull { index, s -> index.takeIf { s.toSet().size == 1 } }

        val emptyColumnIndices = input[0].indices.mapIndexedNotNull { index, i ->
            input.map { it[i] }.toSet().takeIf { it.size == 1 }?.let { index }
        }

        galaxies.map {
            val xShift = emptyRowIndices.count { x -> x < it.x } * (expansionFactor - 1)
            val yShift = emptyColumnIndices.count { y -> y < it.y } * (expansionFactor - 1)
            it to Point(it.x + xShift, it.y + yShift)
        }.forEach {
            galaxies += it.second
            galaxies -= it.first
        }

        return galaxies.indices.sumOf {
            (it + 1 until galaxies.size)
                .sumOf { j -> abs(galaxies[it].x - galaxies[j].x).toLong() + abs(galaxies[it].y - galaxies[j].y).toLong() }
        }
    }
}
