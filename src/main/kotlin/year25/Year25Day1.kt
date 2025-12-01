package year25

import core.Day
import core.InputConverter.Companion.toLines
import kotlin.math.abs
import kotlin.math.sign

class Year25Day1 : Day<List<String>>(::toLines) {

    override fun part1(input: List<String>): Int = parseInput(input).fold(50 to 0) { (acc, times), change ->
        val value = acc + change
        val zeroes = (times + 1).takeIf { value % 100 == 0 } ?: times

        value to zeroes
    }.second

    override fun part2(input: List<String>): Int = parseInput(input).fold(50 to 0) { (acc, times), change ->
        var zeroes = times + abs(change) / 100
        val modChange = change % 100

        val next = acc + modChange

        if (acc != 0 && (next.sign != acc.sign || abs(next) / 100 != abs(acc) / 100 || next % 100 == 0)) {
            zeroes++
        }

        next % 100 to zeroes
    }.second

    private fun parseInput(input: List<String>): List<Int> =
        input.map { it.replace('L', '-').replace('R', '+').toInt() }
}
