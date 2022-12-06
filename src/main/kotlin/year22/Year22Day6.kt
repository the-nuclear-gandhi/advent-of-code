package year22

import shared.Day
import kotlin.streams.toList

class Year22Day6 : Day<String>() {
    override fun getInput(): String = inputResource().asString()

    override fun part1(input: String): Int = searchDistinctCharsOfLength(input, 4)

    override fun part2(input: String): Int = searchDistinctCharsOfLength(input, 14)

    private fun searchDistinctCharsOfLength(input: String, length: Int): Int = input.windowed(length)
        .first { it.chars().distinct().toList().size == length }
        .let { input.indexOf(it) + length }
}
