package year16

import core.Day
import core.InputConverter.Companion.toLines

class Year16Day6 : Day<List<String>>(::toLines) {

    override fun part1(input: List<String>): String = solve(input) { map -> map.keys.maxBy { map.getValue(it) } }

    override fun part2(input: List<String>): String = solve(input) { map -> map.keys.minBy { map.getValue(it) } }

    private fun solve(input: List<String>, selectorFunction: (Map<Char, Int>) -> Char): String =
        input[0].indices.map { i ->
            input.map { it[i] }.groupingBy { it }
                .eachCount()
                .run(selectorFunction)
        }.joinToString("")
}
