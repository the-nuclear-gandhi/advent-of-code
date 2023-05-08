package year22

import shared.Day

class Year22Day1 : Day<List<List<String>>>() {
    override fun getInput(): List<List<String>> = inputResource().asLineBlocks()

    override fun part1(input: List<List<String>>): Int = input.maxOf { sumOfLines(it) }

    override fun part2(input: List<List<String>>): Int =
        input.map { sumOfLines(it) }
            .sortedDescending()
            .take(3)
            .sum()

    private fun sumOfLines(list: List<String>): Int = list.sumOf { it.toIntOrNull() ?: 0 }
}
