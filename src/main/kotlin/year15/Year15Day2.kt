package year15

import core.Day
import core.InputConverter.Companion.toLines
import shared.toLongList

class Year15Day2 : Day<List<String>>(::toLines) {

    override fun part1(input: List<String>): Long =
        input.map { it.toLongList("x") }
            .map { it.plus(it[0]).zipWithNext { a, b -> a * b } }
            .sumOf { it.sumOf { item -> 2 * item } + it.minOrNull()!! }

    override fun part2(input: List<String>): Long =
        input.sumOf {
            val dimensions = it.toLongList("x")
            val perimeters = dimensions.plus(dimensions[0]).zipWithNext { a, b -> 2 * a + 2 * b }
            dimensions.reduce { acc, dimension -> acc * dimension } + perimeters.minOrNull()!!
        }
}
