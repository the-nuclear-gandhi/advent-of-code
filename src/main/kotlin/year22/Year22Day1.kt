package year22

import shared.Day
import shared.InputConverter.Companion.toLineBlocks
import shared.LineBlock

class Year22Day1 : Day<List<LineBlock>>(::toLineBlocks) {

    override fun part1(input: List<LineBlock>): Int = input.maxOf { sumOfLines(it) }

    override fun part2(input: List<LineBlock>): Int =
        input.map { sumOfLines(it) }
            .sortedDescending()
            .take(3)
            .sum()

    private fun sumOfLines(list: List<String>): Int = list.sumOf { it.toIntOrNull() ?: 0 }
}
