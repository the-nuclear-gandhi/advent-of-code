package year22

import shared.Day

class Year22Day1 : Day<String>() {
    override fun getInput(): String = inputResource().asString()

    override fun part1(input: String): Int = input.split("\n\n").maxOf { sumOfLines(it) }

    override fun part2(input: String): Int =
        input.split("\n\n")
            .map { sumOfLines(it) }
            .sortedDescending()
            .take(3)
            .sum()

    private fun sumOfLines(s: String): Int = s.lines().sumOf { it.toIntOrNull() ?: 0 }
}
