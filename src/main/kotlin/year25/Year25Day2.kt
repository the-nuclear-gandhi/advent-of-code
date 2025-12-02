package year25

import core.Day
import core.InputConverter.Companion.trimming
import shared.toLongList

class Year25Day2 : Day<String>(::trimming) {

    override fun part1(input: String): Long = parseInput(input)
        .filter { it.length % 2 == 0 && it.take(it.length / 2) == it.drop(it.length / 2) }
        .sumOf { it.toLong() }

    override fun part2(input: String): Long = parseInput(input)
        .filter { s -> (1..s.length / 2).any { n -> s.chunked(n).let { it.all { chunk -> chunk == it[0] } } } }
        .sumOf { it.toLong() }

    private fun parseInput(input: String): List<String> = input.split(",")
        .flatMap { it.toLongList("-").let { list -> LongRange(list.first(), list.last()) } }
        .map { it.toString() }
}
