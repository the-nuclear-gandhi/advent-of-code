package year21

import shared.Day

class Year21Day1 : Day<List<Int>>() {
    override fun getInput(): List<Int> = inputResource().asLines().map { it.toInt() }

    override fun part1(input: List<Int>): Int = input.zipWithNext().count { it.second > it.first }

    override fun part2(input: List<Int>): Int =
        input.windowed(3)
            .map { it.sum() }
            .zipWithNext()
            .count { it.second > it.first }
}
