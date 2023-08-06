package year15

import core.Day
import core.InputConverter.Companion.toLines

class Year15Day2 : Day<List<String>>(::toLines) {

    override fun part1(input: List<String>): Long =
        input.map { it.split("x").map { token -> token.toLong() } }
            .map { it.plus(it[0]).zipWithNext { a, b -> a * b } }
            .sumOf { it.sumOf { item -> 2 * item } + it.minOrNull()!! }

    override fun part2(input: List<String>): Long =
        input.sumOf {
            val dimensions = it.split("x").map { token -> token.toLong() }
            val perimeters = dimensions.plus(dimensions[0]).zipWithNext { a, b -> 2 * a + 2 * b }
            dimensions.reduce { acc, dimension -> acc * dimension } + perimeters.minOrNull()!!
        }
}
