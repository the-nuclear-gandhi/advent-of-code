package year21

import core.Day
import core.InputConverter.Companion.toInts

class Year21Day1 : Day<List<Int>>(::toInts) {

    override fun part1(input: List<Int>): Int = input.zipWithNext().count { it.second > it.first }

    override fun part2(input: List<Int>): Int =
        input.windowed(3)
            .map { it.sum() }
            .zipWithNext()
            .count { it.second > it.first }
}
