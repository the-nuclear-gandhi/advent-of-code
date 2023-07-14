package year22

import shared.Day
import shared.InputConverter.Companion.toLines

class Year22Day2 : Day<List<String>>(::toLines) {

    override fun part1(input: List<String>): Int = mapOf(
        "A X" to 4, "A Y" to 8, "A Z" to 3,
        "B X" to 1, "B Y" to 5, "B Z" to 9,
        "C X" to 7, "C Y" to 2, "C Z" to 6
    ).let { sumResult(input, it) }

    override fun part2(input: List<String>): Int = mapOf(
        "A X" to 3, "A Y" to 4, "A Z" to 8,
        "B X" to 1, "B Y" to 5, "B Z" to 9,
        "C X" to 2, "C Y" to 6, "C Z" to 7
    ).let { sumResult(input, it) }

    private fun sumResult(input: List<String>, mapping: Map<String, Int>): Int = input.sumOf { mapping[it] ?: 0 }
}
