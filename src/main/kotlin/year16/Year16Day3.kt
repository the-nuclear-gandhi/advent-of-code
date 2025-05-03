package year16

import core.Day
import core.InputConverter.Companion.toLines
import shared.toIntList

class Year16Day3 : Day<List<String>>(::toLines) {

    override fun part1(input: List<String>): Int = input.map { it.toIntList() }
        .count(::isValidTriangle)

    override fun part2(input: List<String>): Int = input.map { it.toIntList() }
        .run {
            val transformedList = mutableListOf<Int>()
            repeat(3) { i ->
                transformedList.addAll(this.map { it[i] }.toList())
            }

            transformedList.chunked(3)
                .count(::isValidTriangle)
        }

    private fun isValidTriangle(input: List<Int>): Boolean = run {
        require(input.size == 3) { "Input list must be of size 3" }
        input.all { it < input.sum() - it }
    }
}
