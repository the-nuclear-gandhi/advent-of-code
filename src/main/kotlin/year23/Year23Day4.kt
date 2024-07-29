package year23

import core.Day
import core.InputConverter.Companion.toLines
import shared.toIntList

class Year23Day4 : Day<List<String>>(::toLines) {

    override fun part1(input: List<String>): Int = parseInput(input)
        .map { (winning, received) -> received.count { it in winning } }
        .filter { it > 0 }
        .sumOf { 1.shl(it - 1) }

    override fun part2(input: List<String>): Int = IntArray(input.size) { 1 }
        .apply {
            parseInput(input).mapIndexed { index, (winning, received) ->
                received.count { it in winning }
                    .let { index + 1..index + it }
                    .forEach { this[it] += this[index] }
            }
        }
        .sum()

    private fun parseInput(input: List<String>): List<Pair<List<Int>, List<Int>>> = input.map {
        val winningNumbers = it.substringAfter(":").substringBefore("|").toIntList()
        val receivedNumbers = it.substringAfter("|").toIntList()

        winningNumbers to receivedNumbers
    }
}

